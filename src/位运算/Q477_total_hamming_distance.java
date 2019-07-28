package 位运算;

public class Q477_total_hamming_distance {
    public int totalHammingDistance(int[] nums) {
        /*
       思入: 按列去看待
       0100
       1110
       0010
       左边第1列: 2个0,1个1,不同组合后增加的距离是2*1=2,
       左边第2列: 1个0,2个1,不同组合增加距离2*1=2
       左边第3列: 2个0,1个1,不同组合增加距离2*1=1
       左边第4列: 3个0,0个1,不同组合增加距离3*0=3
       所以问题转为对应列上有多少个1
        */
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int countOne = 0;
            for (int j = 0; j < nums.length; j++) {
                countOne += (nums[j] & 1);
                nums[j] >>>= 1;
            }
            result += (nums.length - countOne) * countOne;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 14, 2};
        Q477_total_hamming_distance s = new Q477_total_hamming_distance();
        int i1 = s.totalHammingDistance(nums);
        System.out.println(i1);
    }
}
