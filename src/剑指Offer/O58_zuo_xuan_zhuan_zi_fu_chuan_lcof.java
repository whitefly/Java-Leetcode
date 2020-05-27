package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class O58_zuo_xuan_zhuan_zi_fu_chuan_lcof {
    public String reverseLeftWords(String s, int n) {
        if (n == 1) return s;
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, chars.length - 1);
        reverse(chars, 0, s.length() - 1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) sb.append(chars[i]);
        return sb.toString();
    }

    void reverse(char[] chars, int L, int R) {
        while (L < R) {
            char c = chars[L];
            chars[L++] = chars[R];
            chars[R--] = c;
        }
    }

    public static void main(String[] args) {
        O58_zuo_xuan_zhuan_zi_fu_chuan_lcof s = new O58_zuo_xuan_zhuan_zi_fu_chuan_lcof();
        System.out.println(s.reverseLeftWords("1234567", 2));
    }
}
