package 回溯剪枝;

import java.util.Arrays;

public class Q494_target_sum {
    private int result = 0;

    public int findTargetSumWays(int[] nums, int S) {
        /*
        思入1: 暴力法 DFS搜索全部组合
         */
        helper(nums, 0, 0, S);
        return result;
    }

    private void helper(int[] nums, int i, int sum, int S) {
        if (nums.length == i) {
            if (sum == S) result++;
            return;
        }
        helper(nums, i + 1, sum + nums[i], S);
        helper(nums, i + 1, sum - nums[i], S);
    }

    public int findTargetSumWays2(int[] nums, int S) {
        long totalSum = 0;
        for (int num : nums) totalSum += num;

        if (((totalSum + S) & 1) == 1 || totalSum < S) return 0;
        int target = (int) (totalSum + S) / 2;
        //装为01背包问题 dp[i][sum] 表示 前i个元素参与决策,组成和为sum的个数
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) dp[j] += dp[j - nums[i]];
        }
        return Math.max(dp[target], 0);
    }


    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        Q494_target_sum s = new Q494_target_sum();
        System.out.println(s.findTargetSumWays2(nums, S));
    }


}
