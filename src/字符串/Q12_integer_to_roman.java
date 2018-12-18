package 字符串;

import java.util.HashMap;

public class Q12_integer_to_roman {
    public String intToRoman(int num) {
        /**
         *  思想: 核心就是进制转化,只不过进制多一点而已
         */
        StringBuilder r = new StringBuilder();
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] Rome = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        for (int i = 0; i < 13; i++) {
            int divide = nums[i];
            String str = Rome[i];
            int time = num / divide;
            num %= divide;
            for (int j = 0; j < time; j++) r.append(str);
        }
        return r.toString();
    }

    public static void main(String[] args) {
        Q12_integer_to_roman s = new Q12_integer_to_roman();
        String s1 = s.intToRoman(58);
        System.out.println(s1);
    }
}
