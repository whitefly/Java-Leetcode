package 动态规划;

import java.util.Arrays;

public class Q188_best_time_to_buy_and_sell_stock_iv {
    public int maxProfit(int limitK, int[] prices) {
        /*
        思入: 动态规划,和iii一样,但是最后几个例子limitK会给很大limitK=1000000000,,导致空间超出
        所以当 交易次数k > 价格数量/2时, 就变为交易任意次问题,此时可以使用ii的贪心来完成
         */
        if (limitK < 1) return 0;
        if (limitK >= prices.length / 2) return greedy(prices);

        int[][] dp = new int[limitK + 1][2];
        for (int[] ints : dp) Arrays.fill(ints, -1000000);
        dp[0][0] = 0;
        for (int price : prices) {
            for (int k = 1; k <= limitK; k++) {
                dp[k][1] = Math.max(dp[k][1], dp[k][0] - price);
                dp[k][0] = Math.max(dp[k][0], dp[k - 1][1] + price);
            }
            dp[0][1] = Math.max(dp[0][1], -price);
        }
        int result = 0;
        for (int[] ints : dp) for (int num : ints) result = Math.max(result, num);
        return result;
    }

    private int greedy(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1])
                max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
