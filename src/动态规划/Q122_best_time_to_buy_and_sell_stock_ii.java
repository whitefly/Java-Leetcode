package 动态规划;

import java.util.Arrays;

public class Q122_best_time_to_buy_and_sell_stock_ii {
    public int maxProfit(int[] prices) {
        /**
         * 思入: 贪心策略. 使用一个变量来记录现在是否持有股票.
         * 购买: 购买时要保证一定可以卖出  即price[i]<price[i+1];
         * 卖出: 卖出时要是能赚钱的. 即price[i]>price[i+1]; 否则就延后卖了
         */
        boolean hold = false;
        int cost = -1;
        int size = prices.length;
        int earning = 0;
        for (int i = 0; i < size; i++) {
            if (hold) {
                if (i == size - 1 || prices[i] > prices[i + 1]) {
                    earning += prices[i] - cost;
                    hold = false;
                }
            } else {
                if (i < size - 1 && prices[i] < prices[i + 1]) {
                    cost = prices[i];
                    hold = true;
                }
            }
        }
        return earning;
    }

    public int maxProfit2(int[] prices) {
        /*
        动态规划法: 动态规划 dp[i][k][s] 表示到i天为止,恰好使用了k次交易(必须都用上),最后处于s状态时,最大的利润数
        类似于完全背包,k有限制, k<= size/2;
        直接写出空间优化后的代码
         */
        int limitK = prices.length / 2;
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
        int[] prices = {7, 6, 4, 3, 1};
        Q122_best_time_to_buy_and_sell_stock_ii s = new Q122_best_time_to_buy_and_sell_stock_ii();
        int i = s.maxProfit(prices);
        System.out.println(i);
    }
}
