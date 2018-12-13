package 字符串;

public class Q7_reverse_integer {
    public int reverse(int x) {
        /**
         * 思入: 转为字符串,反转,在转移回数字. (需要调用字符串转数字的api,比较无脑的写法)
         */

        long k = (long) x;
        boolean is_positve = (k >= 0);
        k = is_positve ? k : -k;
        String str_x = new StringBuilder(String.valueOf(k)).reverse().toString();
        long r = (is_positve ? 1 : -1) * Long.valueOf(str_x);
        return (r > Integer.MAX_VALUE || r < Integer.MIN_VALUE) ? 0 : (int) r;
    }

    public int reverse2(int x) {
        /**
         * 思入: (不借助字符串),不断取得原数字的右边,构造新的数字,
         */
        int r = 0;
        while (x != 0) {
            int temp = r * 10 + x % 10;
            //判断是否乘法溢出,乘法溢出会导致最高位被截取,所以逆操作还原后,和r不同
            if ((temp / 10) != r) return 0;
            r = temp;
            x /= 10;
        }
        return r;

    }

    public static void main(String[] args) {
        Q7_reverse_integer s = new Q7_reverse_integer();
        System.out.println(s.reverse2(
                123));
    }
}
