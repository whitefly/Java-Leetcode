package 动态规划;

public class Q198_house_robber {
    public int rob(int[] nums) {
        /**
         * 思入: 可以连续跳2个,所以奇数和偶数的思入不对
         * 动态规划:  到该点为止,满足
         */
        int size = nums.length;
        int result = 0;
        for (int i = 0; i < size; i++) {
            int temp_max = 0;
            if (i >= 2) {
                int limit = i - 2;
                for (int j = 0; j <= limit; j++) {
                    temp_max = Math.max(temp_max, nums[i]);
                }
            }
            nums[i] += temp_max;
            result = Math.max(result, nums[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Q198_house_robber s = new Q198_house_robber();
        int rob = s.rob(nums);
        System.out.println(rob);
    }
}
