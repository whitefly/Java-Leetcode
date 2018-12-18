package 字符串;

import java.util.Arrays;

public class Q13_roman_to_integer {
    public int romanToInt(String s) {
        /**
         *思入: 从右到左遍历按字符遍历, 设置一个阈值符号位threshold,若遍历到的字符代表的数字<阈值,则减去该字符对应的数值. 阈值符号位是慢慢增大的
         */
        int[] map = {0, 0, 100, 500, 0, 0, 0, 0, 1, 0, 0, 50, 1000, 0, 0, 0, 0, 0, 0, 0, 0, 5, 0, 10, 0, 0};
        int threshold = 1, result = 0;
        char[] chars = s.toCharArray();
        int size = chars.length;
        for (int i = size - 1; i >= 0; i--) {
            int num = map[chars[i] - 'A'];
            if (num >= threshold) {
                threshold = num;
                result += num;
            } else result -= num;
        }
        return result;
    }

    public static void main(String[] args) {
        Q13_roman_to_integer s = new Q13_roman_to_integer();
        int r = s.romanToInt("LVIII");
        System.out.println(r);

    }
}
