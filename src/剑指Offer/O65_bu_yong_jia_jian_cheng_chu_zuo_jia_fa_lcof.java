package 剑指Offer;

public class O65_bu_yong_jia_jian_cheng_chu_zuo_jia_fa_lcof {
    public static int add(int a, int b) {
        //位运算
        int cum = a, result = b, temp;
        while (cum != 0) {
            temp = result ^ cum;
            cum = (result & cum) << 1;
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(add(-1, 1));

    }
}
