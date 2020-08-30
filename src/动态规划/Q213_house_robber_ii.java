package 动态规划;

import javax.swing.*;

public class Q213_house_robber_ii {
    public int rob(int[] nums) {
        /*
        思入: 可以分为2种情况
        情况1: 使用了下标为0的元素
        情况2: 未使用下标为0的元素
         */
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[][] dp = new int[nums.length][2];
        //第1种情况,一定使用了下标为1的元素
        return Math.max(helper(nums, dp, true), helper(nums, dp, false));
    }

    public int helper(int[] nums, int[][] dp, boolean useFirst) {
        dp[0][0] = useFirst ? Integer.MIN_VALUE : 0;
        dp[0][1] = useFirst ? nums[0] : Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int last = nums.length - 1;
        return useFirst ? dp[last][0] : Math.max(dp[last][0], dp[last][1]);
    }


    public int rob2(int[] nums) {
        //将环形转为2个单数组问题[0,n-1],[1,n]
        //dp[i]表示使用完前i后,最大的金额
        // dp[i] = max(dp[i-1],dp[i-2]+nums[i])
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return Math.max(helper2(nums, 0, nums.length - 2), helper2(nums, 1, nums.length - 1));
    }

    public int helper2(int[] nums, int L, int R) {
        if (L == R) return nums[L];
        if ((L + 1) == R) return Math.max(nums[L], nums[R]);
        int[] dp = new int[nums.length];
        dp[L] = nums[L];
        dp[L + 1] = Math.max(nums[L], nums[L + 1]);
        for (int i = L + 2; i <= R; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[R];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        Q213_house_robber_ii s = new Q213_house_robber_ii();
        System.out.println(s.rob2(nums));
    }

}
