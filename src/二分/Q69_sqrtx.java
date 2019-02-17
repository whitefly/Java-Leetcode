package 二分;

public class Q69_sqrtx {
    public int mySqrt(int x) {
        /**
         * 思入: 直接调用sqrt函数
         */
        return (int) Math.sqrt((double) x);
    }

    public int mySqrt2(int x) {
        /**
         * 思入: 使用2分,为了防止乘法溢出的问题,使用multiplyExact
         */
        if (x == 0) return 0;
        int l = 1, r = x;
        while (l + 1 < r) {
            int mid = l + (r - l) / 2;
            try {
                int pow = Math.multiplyExact(mid, mid);
                if (pow == x) return mid;
                if (pow < x) l = mid;
                else r = mid - 1;
            } catch (ArithmeticException e) {
                r = mid - 1;
            }
        }
        //最后2个数
        try {
            return Math.multiplyExact(r, r) < x ? r : l;
        } catch (ArithmeticException e) {
            return l;
        }
    }

    public static void main(String[] args) {
        Q69_sqrtx s = new Q69_sqrtx();
        int i = s.mySqrt2(7);
        System.out.println(i);
    }
}
