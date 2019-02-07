package 动态规划;

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

    public static void main(String[] args) {
        int[] nums = {7, 6, 4, 3, 1};
        Q121_best_time_to_buy_and_sell_stock s = new Q121_best_time_to_buy_and_sell_stock();
        int i = s.maxProfit(nums);
        System.out.println(i);
    }
}
