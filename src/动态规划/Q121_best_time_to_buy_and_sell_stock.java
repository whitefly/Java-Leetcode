package 动态规划;

import java.util.Arrays;

public class Q121_best_time_to_buy_and_sell_stock {
    public int maxProfit(int[] prices) {
        /**
         * 思入:  寻找nums[i]左边最小值. 设置一个变量记录最小值
         */
        if (prices.length == 0) return 0;
        int min_price = prices[0];
        int result = 0;
        for (int price : prices) {
            result = Math.max(result, price - min_price);
            min_price = Math.min(min_price, price);
        }
        return result;
    }

    public int maxProfit2(int[] prices) {
        /*
        思入2: 动态规划 dp[i][k][s] 表示到i天为止,恰好使用k次交易,最后处于s状态时,最大的利润数
        k从1开始循环
         */
        int[][][] dp = new int[prices.length + 1][2][2];
        dp[0][1][0] = dp[0][1][1] = dp[0][0][1] = -1000000;  //初始化状态
        for (int i = 1; i <= prices.length; i++) {
            dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i - 1]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][0][1] + prices[i - 1]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], dp[i - 1][1][0] - prices[i - 1]);
        }
        int result = 0;
        for (int k = 0; k < 2; k++) {
            for (int s = 0; s < 2; s++) {
                result = Math.max(dp[prices.length][k][s], result);
            }
        }
        return result;
    }

    public int maxProfit3(int[] prices) {
        /*
        思入3:在思入2的基础上,优化空间,只保留上一天的状态.  此时求dp11,dp10,dp01的顺序不能错.
         */
        int dp01, dp10, dp11;
        dp01 = dp10 = dp11 = -1000000;
        for (int price : prices) {
            dp11 = Math.max(dp11, dp10 - price);
            dp10 = Math.max(dp10, dp01 + price);
            dp01 = Math.max(dp01, -price);
        }
        return Math.max(Math.max(0, dp01), Math.max(dp10, dp11));
    }

    public static void main(String[] args) {
        int[] nums = {7, 6, 4, 3, 1};
//        int[] nums = {3, 3, 5, 0, 0, 3, 1, 4};
//        int[] nums = {1, 2, 3, 4, 5};
        Q121_best_time_to_buy_and_sell_stock s = new Q121_best_time_to_buy_and_sell_stock();
        System.out.println(s.maxProfit(nums));
        System.out.println(s.maxProfit2(nums));
        System.out.println(s.maxProfit3(nums));
    }
}
