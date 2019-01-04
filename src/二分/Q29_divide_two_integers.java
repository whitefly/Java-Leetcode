package 二分;

public class Q29_divide_two_integers {
    public int divide(int dividend, int divisor) {
        /**
         *  思入: 由于不能使用乘法,所以只能使用减法,但单纯的减法太慢,使用二分法加倍
         */
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean sign = ((dividend ^ divisor) >= 0);
        //为了防止负变正的溢出,dividend,divisor,now_divisor,now_add同一转为long,
        long num1 = Math.abs((long) dividend), num2 = Math.abs((long) (divisor));

        int result = 0;
        while (num1 >= num2) {
            long now_divisor = num2;
            long now_add = 1;
            while (num1 >= now_divisor) {
                num1 -= now_divisor;
                result += now_add;
                now_divisor <<= 1;
                now_add <<= 1;
            }
        }
        return sign ? result : -result;
    }

    public static void main(String[] args) {
        Q29_divide_two_integers s = new Q29_divide_two_integers();
        int divide = s.divide(7, -3);
        System.out.println(divide);
    }
}
