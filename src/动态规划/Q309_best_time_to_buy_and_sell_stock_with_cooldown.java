package 动态规划;

public class Q309_best_time_to_buy_and_sell_stock_with_cooldown {
    public int maxProfit(int[] prices) {
        /*
        思入:  dp[i][s]表示第i天为止,最后处于s状态,所获得的最大利润.
        s有3种状态:持有(Hold),没有持有(UnHold),今天卖出(Sold该题额外添加的状态)
        状态转移方程:
            dp[i][持有]= Max(dp[i-1][持有],dp[i-1][没有持有]-prices[i])
            dp[i][没有持有]=Max(dp[i-1][没有持有],dp[i-1][今天卖出])
            dp[i][今天卖出]=dp[i-1][持有]+prices[i]
            其中i>=1

         写出base case: dp[0][持有]= -prices[0] dp[0][没有持有]=0, dp[0][今天卖出]=-无穷
         */
        if (prices.length <= 1) return 0;
        int hold = -prices[0], unHold = 0, sold = -100000;
        int tempHold, tempUnHold, tempSold;
        for (int i = 1; i < prices.length; i++) {
            tempUnHold = Math.max(unHold, sold);
            tempHold = Math.max(hold, unHold - prices[i]);
            tempSold = hold + prices[i];

            hold = tempHold;
            unHold = tempUnHold;
            sold = tempSold;
        }
        return Math.max(unHold, sold);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 0, 2};
        Q309_best_time_to_buy_and_sell_stock_with_cooldown s = new Q309_best_time_to_buy_and_sell_stock_with_cooldown();
        System.out.println(s.maxProfit(nums));
    }
}
