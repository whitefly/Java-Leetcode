package 动态规划;

public class Q714_best_time_to_buy_and_sell_stock_with_transaction_fee {
    public int maxProfit(int[] prices, int fee) {
        /*
         思入: dp[i][s]表示第i天为止,最后处于s状态,所获得的最大利润.
         s的状态: 持有(hold) 未持有(unHold)
         状态转移方程:
            dp[i][持有]= Max(dp[i-1][持有],dp[i-1][未持有]-prices[i]);
            dp[i][未持有]=Max(dp[i-1][未持有],dp[i-1][持有]+prices[i]-fee)
            i>=1
         case base:
            dp[0][持有]=-prices[0]
            dp[0][未持有]=0
         直接写出空间优化过的代码
         */
        if (prices.length <= 1) return 0;
        int hold = -prices[0], unHold = 0;
        int tempHold, tempUnHold;
        for (int i = 1; i < prices.length; i++) {
            tempHold = Math.max(hold, unHold - prices[i]);
            tempUnHold = Math.max(unHold, hold + prices[i] - fee);

            hold = tempHold;
            unHold = tempUnHold;
        }
        return Math.max(hold, unHold);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        Q714_best_time_to_buy_and_sell_stock_with_transaction_fee s = new Q714_best_time_to_buy_and_sell_stock_with_transaction_fee();
        System.out.println(s.maxProfit(nums, fee));
    }
}
