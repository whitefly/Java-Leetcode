package 背包问题;

import java.util.Arrays;

public class Q416_partition_equal_subset_sum {
    public boolean canPartition(int[] nums) {
        /*
         思入: 01背包问题,  总重为总和的一盘, 单个元素的value就是1. 判断是否达到.
         */
        int sum = 0;
        for (int num : nums) sum += num;
        if ((sum & 1) == 1) return false;
        sum >>= 1;
        //01背包,不需要最大最小,是需要 是和否即可. 所以用boolean
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = sum; j >= 0; j--) {
                dp[j] = (j - nums[i] >= 0) ? dp[j] || dp[j - nums[i]] : dp[j];
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        Q416_partition_equal_subset_sum s = new Q416_partition_equal_subset_sum();
        int[] nums = {1, 2, 5};
        System.out.println(s.canPartition(nums));
    }
}
