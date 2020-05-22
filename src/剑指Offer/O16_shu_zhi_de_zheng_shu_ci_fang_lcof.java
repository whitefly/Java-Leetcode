package 剑指Offer;

public class O16_shu_zhi_de_zheng_shu_ci_fang_lcof {
    public static double myPow(double x, int n) {
        //二分加速
        long count = 1;
        double base = x;
        double result = 1;
        boolean neg = false;
        long l = n;
        if (l < 0) {
            l = -l;
            neg = true;
        }
        while (l > 0) {
            if (l >= count) {
                l -= count;
                result *= base;
                count <<= 1;
                base *= base;
            } else {
                count = 1;
                base = x;
            }
        }
        return neg ? 1 / result : result;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.00000, -2147483648));
    }
}
