package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q377_combination_sum_iv {
    int count = 0;


    public int combinationSum4(int[] nums, int target) {
        /**
         * 思入: 回溯剪枝. target较大时,分支太多,过例子12/17时,直接超时
         */
        helper(nums, target, 0);
        return count;
    }

    private void helper(int[] nums, int target, int sum) {
        if (target <= sum) {
            if (target == sum) count++;
            return;
        }
        for (int num : nums) helper(nums, target, sum + num);
    }

    public int combinationSum42(int[] nums, int target) {
        /**
         * 思入: 动态规划. dp[i]为和为i的组合数, dp[i]为之前的累积和dp[i-num1]+dp[i-num2]+dp[i-num3]+...
         * 类似于素数的筛法
         */
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int num : nums) {
                int sum = num + i;
                if (sum <= target) dp[sum] += dp[i];
            }
        }
        return dp[target];
    }

    public int combinationSum43(int[] nums, int target) {
        /**
         * 动态规划的递归版
         */
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        return helper2(nums, target, dp);
    }

    private int helper2(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) return dp[target];
        dp[target] = 0;
        for (int num : nums) {
            if (target - num < 0) continue;
            dp[target] += helper2(nums, target - num, dp);
        }
        return dp[target];
    }


    public static void main(String[] args) {
        Q377_combination_sum_iv s = new Q377_combination_sum_iv();
        int[] nums = {1, 2, 3};
        int target = 4;
        int i = s.combinationSum43(nums, target);
        System.out.println(i);
    }
}
