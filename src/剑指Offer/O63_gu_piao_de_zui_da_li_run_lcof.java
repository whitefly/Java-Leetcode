package 剑指Offer;

public class O63_gu_piao_de_zui_da_li_run_lcof {
    public int maxProfit(int[] prices) {
        //若仅仅卖一次,只需要得到只能左边最小值即可
        if (prices == null || prices.length <= 1) return 0;
        int min = prices[0], result = 0;
        for (int price : prices) {
            min = Math.min(price, min);
            result = Math.max(price - min, result);
        }
        return result;
    }


}
