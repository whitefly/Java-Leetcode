package 动态规划;

import java.util.Arrays;

public class Q198_house_robber {
    public int rob(int[] nums) {
        /**
         * 思入: 动态规划:  到i点为止(包含该点),所偷到的最大的金额. 需要扫0-i-2点所有的位置,找一个最大的跟在后面
         * 可以简化计算,
         */
         /*
        思入: 类似股票买卖的冷冻期
        状态量:
        dp[i][false] 表示前i个参与决策,则第i个已经偷了,所获得的最大利润
        dp[i][true] 表示前i个参与决策,则第i个没有偷,所获得的最大利润
        转移方程:
        dp[i][false]= max(dp[i-1][true],dp[i-1][false])
        dp[i][true]=  dp[i-1][false]+nums[i];
        可以进行空间优化(懒得写了)
         */
        if (nums.length == 0) return 0;

        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][1], dp[i - 1][0]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }
        int last = nums.length - 1;
        return Math.max(dp[last][0], dp[last][1]);
    }

    public int rob2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Q198_house_robber s = new Q198_house_robber();
        int rob = s.rob(nums);
        System.out.println(rob);
    }
}
