package 动态规划;

import java.util.Arrays;

public class Q123_best_time_to_buy_and_sell_stock_iii {
    /*
     思入:  将买卖股票ii的k变为给定的k即可,
     */
    public int maxProfit(int[] prices) {
        int limitK = 2;  //此时k=2,3,4...第可以
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

    public static void main(String[] args) {
//        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        int[] prices = {7, 6, 4, 3, 1};
        Q123_best_time_to_buy_and_sell_stock_iii s = new Q123_best_time_to_buy_and_sell_stock_iii();
        System.out.println(s.maxProfit(prices));
    }
}
