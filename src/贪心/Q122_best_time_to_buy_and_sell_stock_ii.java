package 贪心;

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

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        Q122_best_time_to_buy_and_sell_stock_ii s = new Q122_best_time_to_buy_and_sell_stock_ii();
        int i = s.maxProfit(prices);
        System.out.println(i);
    }
}
