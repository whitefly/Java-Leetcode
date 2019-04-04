package 重复元素;

public class Q136_single_number {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) result ^= num;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        Q136_single_number s = new Q136_single_number();
        int i = s.singleNumber(nums);
        System.out.println(i);
    }
}
