package 数学结论;

import java.util.Map;

public class Q400_nth_digit {
    public int findNthDigit(int n) {
        /**
         * 思入1:暴力法,累加个数(超时)
         */
        long count = 0;
        for (long i = 1; i <= Integer.MAX_VALUE; i++) {
            String str = String.valueOf(i);
            int num_len = str.length();
            count += num_len;
            if (n <= count) {
                char c = str.charAt(num_len - (int) (count - n) - 1);
                return c - '0';
            }
        }
        return -1;
    }

    public int findNthDigit2(int n) {
        /**
         * 思入: 坐标转换法. 将n确定在哪个范围上
         */
        if (n < 10) return n;
        int range_size = 10;
        int num_size = 1;
        while (range_size < n) {
            num_size++;
            n -= range_size;
            range_size = (int) (num_size * (Math.pow(10, num_size) - Math.pow(10, num_size - 1)));
        }
        //根据n下标,来计算位置
        int index = n / num_size;
        int mod = n % num_size;
        int num = (int) Math.pow(10, num_size - 1) + index;
        return String.valueOf(num).charAt(mod) - '0';
    }

    public static void main(String[] args) {
        Q400_nth_digit s = new Q400_nth_digit();
        int i = 2222;
        int nthDigit = s.findNthDigit(i);
        System.out.println(nthDigit);
        int nthDigit2 = s.findNthDigit2(i);
        System.out.println(nthDigit2);
    }
}
