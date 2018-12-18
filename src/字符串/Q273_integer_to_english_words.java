package 字符串;

import java.util.HashMap;


public class Q273_integer_to_english_words {

    private String[] map = new String[91];

    {
        map[1] = "One";
        map[2] = "Two";
        map[3] = "Three";
        map[4] = "Four";
        map[5] = "Five";
        map[6] = "Six";
        map[7] = "Seven";
        map[8] = "Eight";
        map[9] = "Nine";
        map[10] = "Ten";
        map[11] = "Eleven";
        map[12] = "Twelve";
        map[13] = "Thirteen";
        map[14] = "Fourteen";
        map[15] = "Fifteen";
        map[16] = "Sixteen";
        map[17] = "Seventeen";
        map[18] = "Eighteen";
        map[19] = "Nineteen";
        map[20] = "Twenty";
        map[30] = "Thirty";
        map[40] = "Forty";
        map[50] = "Fifty";
        map[60] = "Sixty";
        map[70] = "Seventy";
        map[80] = "Eighty";
        map[90] = "Ninety";
    }

    private String numberToWords_helper(int num) {
        //传入1-999的数字,转为字符串
        //百位
        StringBuilder r = new StringBuilder(32);
        int time = num / 100;
        if (time != 0) {
            r.append(map[time] + " Hundred ");
            num %= 100;
        }
        //十位
        time = num / 10;
        if (time > 1) {
            r.append(map[time * 10] + " ");
            num -= time * 10;
        }
        //个位(11也一同看做个位)
        if (num != 0) r.append(map[num] + " ");
        return r.toString();
    }

    public String numberToWords(int num) {
        /**
         *思想字符串到数字:分词,从左到右遍历每个词, 设置表示单位(从1开始), 碰到Thousand,变为1000,碰到Million变为1000000, 在内部设置内部单位(用来解决Hundred)
         *思想数字到字符串: 从左到右
         */
        if (num == 0) return "Zero";
        int[] nums = {1000000000, 1000000, 1000, 1};
        String[] words = {"Billion", "Million", "Thousand"};
        StringBuilder r = new StringBuilder(128);
        for (int i = 0; i < 4; i++) {
            int temp = num / nums[i];
            if (temp > 0) {
                r.append((numberToWords_helper(temp)));
                if (i != 3) r.append(words[i] + " ");
                num %= nums[i];
            }
        }
        //去掉最后的空格
        return r.substring(0, r.length() - 1);
    }


    public static void main(String[] args) {
        Q273_integer_to_english_words s = new Q273_integer_to_english_words();
        System.out.println(s.numberToWords(1234567));


    }
}
