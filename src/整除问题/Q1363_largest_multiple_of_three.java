package 整除问题;

public class Q1363_largest_multiple_of_three {
    public String largestMultipleOfThree(int[] digits) {
        // 每个数的累加被3整除,说明整体可以被3整除. 无法整除,就去掉余数为1或者2的数
        int[] count = new int[10], modCount = new int[3];
        int acc = 0;
        for (int i : digits) {
            count[i]++;
            modCount[i % 3]++;
            acc += i;
        }
        int zeroCount = count[0];

        //判断需要减少的个数
        int removeMod = 1, removeCount = 0;
        if (acc % 3 == 1) {
            if (modCount[1] >= 1) {
                removeMod = 1;
                removeCount = 1;
            } else if (modCount[2] >= 2) {
                removeMod = 2;
                removeCount = 2;
            } else return "";
        } else if (acc % 3 == 2) {
            if (modCount[2] >= 1) {
                removeMod = 2;
                removeCount = 1;
            } else if (modCount[1] >= 2) {
                removeMod = 1;
                removeCount = 2;
            } else return "";
        }

        //加入
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int mod = i % 3;
            while (count[i] > 0) {
                if (mod == removeMod && removeCount > 0) {
                    removeCount--;
                } else {
                    sb.append(i);
                }
                count[i]--;
            }
        }
        //去除全0的情况
        if (sb.length() > 0 && sb.charAt(sb.length() - 1) == '0') return "0";
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int[] nums = {1};
        Q1363_largest_multiple_of_three solution = new Q1363_largest_multiple_of_three();
        System.out.println(solution.largestMultipleOfThree(nums));
    }
}
