package 位运算;

public class Q201_bitwise_and_of_numbers_range {
    public int rangeBitwiseAnd(int m, int n) {
        /**
         * 思入: 通过穷举观察,发现某位上的11110000是周期性连续出现的, 一旦m和n中间的个数超过周期,则一定不可能全部为1.该位的最后结果一定0
         * 所以,通过/和%算出初始n处于哪个周期和剩余连续1的个数,然后范围内数的个数进行比较,来判断该位是否为1.
         * 只有为奇数周期 剩余连续的数个数 <= 总个数, 改位才能为1
         *
         */
        int gap = n - m + 1;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int divide = 1 << i;
            int level = m / divide;
            int rest = divide - m % divide;
            if (level % 2 == 1 && gap <= rest) {
                result += divide;
            }
        }
        return result;
    }

    private static String showBinary(int n) {
        StringBuilder some = new StringBuilder(Integer.toBinaryString(n));
        if (some.length() < 32) {
            int need = 32 - some.length();
            for (int j = 0; j < need; j++) {
                some.insert(0, "0");
            }
        }
        return some.toString();
    }

    public static void main(String[] args) {
        int start = 0;
        int end = 1;
        int result = -1;
        for (int i = start; i <= end; i++) {
            System.out.println(showBinary(i) + " : " + i);
            result &= i;
        }


        System.out.println();
        System.out.println(showBinary(start));
        System.out.println(showBinary(end));
        System.out.println(showBinary(result) + " : " + result);

        Q201_bitwise_and_of_numbers_range s = new Q201_bitwise_and_of_numbers_range();
        int i = s.rangeBitwiseAnd(start, end);
        System.out.println(i);
    }
}
