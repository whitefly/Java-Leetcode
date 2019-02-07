package 二分;

public class Q50_powx_n {
    public double myPow(double x, int n) {
        /**
         * 思入: 二分来加快求幂
         */

        x = n >= 0 ? x : 1 / x;
        double result = 1;
        long new_n = Math.abs((long) n);
        while (new_n > 0) {
            long time = 1;
            double multipiler = x;

            while (new_n >= time) {
                result *= multipiler;
                new_n -= time;
                //加倍
                time <<= 1;
                multipiler *= multipiler;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q50_powx_n s = new Q50_powx_n();
        double x = 2.00000;
        int n = -2147483648;
        double v = s.myPow(x, n);
        System.out.println(v);
    }
}
