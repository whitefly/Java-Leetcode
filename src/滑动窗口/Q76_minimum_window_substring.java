package 滑动窗口;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q76_minimum_window_substring {
    public String minWindow(String s, String t) {
        /*
        思入: 滑动指针. 用字符串hash来存储,一直右移动指针,新加入元素,知道移动至满足特定条件时,移动左指针
        窗口的原则: 包含全部所需的字符
         */

        char[] s1 = s.toCharArray(), s2 = t.toCharArray();
        int[] hash1 = new int[128], hash2 = new int[128];

        int count = 0; //用与初始化步骤的变量,表示还剩下多少个字符没有被满足
        for (char c : s2) {
            hash2[c]++;
            if (hash2[c] == 1) count++;
        }
        //初始化:移动到第一个符合条件的地方
        int R;
        for (R = 0; R < s.length(); R++) {
            char c = s1[R];
            hash1[c]++;
            if (hash1[c] == hash2[c]) {
                count--;
                if (count == 0) {
                    //恰好符合
                    hash1[c]--;
                    break;
                }
            }
        }
        if (count != 0) return "";
        //保持符合条件下,开始滑动
        int L = 0;
        String result = s.substring(L, R + 1);
        for (; R < s.length(); R++) {
            hash1[s1[R]]++;
            //回缩
            while (hash1[s1[L]] - 1 >= hash2[s1[L]]) hash1[s1[L++]]--;
            //比较取小
            if ((R - L + 1) < result.length()) result = s.substring(L, R + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String S = "ADOBECODEBANC", T = "ABC";
        Q76_minimum_window_substring s = new Q76_minimum_window_substring();
        System.out.println(s.minWindow(S, T));
    }
}
