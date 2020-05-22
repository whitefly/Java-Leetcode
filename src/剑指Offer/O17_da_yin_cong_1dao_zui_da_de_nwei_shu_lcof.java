package 剑指Offer;

public class O17_da_yin_cong_1dao_zui_da_de_nwei_shu_lcof {
    public int[] printNumbers(int n) {
        int limit = 1;
        for (; n > 0; n--) limit *= 10;
        limit--;
        int[] result = new int[limit];
        for (int i = 1; i <= limit; i++) {
            result[i - 1] = i;
        }
        return result;
    }
}
