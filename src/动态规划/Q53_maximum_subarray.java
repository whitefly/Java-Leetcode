package 动态规划;

public class Q53_maximum_subarray {
    public int maxSubArray(int[] nums) {
        /**
         * 思入: 动态规划. 包含本位置的最大子数组.
         * 状态:  dp[i]=dp[i-1]>=0? dp[i-1]+nums[i] : nums[i]
         */

        int last_dp = Integer.MIN_VALUE;
        int result = Integer.MIN_VALUE;
        for (int num : nums) {
            last_dp = last_dp >= 0 ? last_dp + num : num;
            result = Math.max(result, last_dp);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        Q53_maximum_subarray s = new Q53_maximum_subarray();
        int i = s.maxSubArray(nums);
        System.out.println(i);
    }
}
