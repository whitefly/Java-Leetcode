package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class O48_zui_chang_bu_han_zhong_fu_zi_fu_de_zi_zi_fu_chuan_lcof {
    public static int lengthOfLongestSubstring(String s) {
        //滑动指针和收缩
        boolean[] bits = new boolean[128];
        int L = 0, R = 0, result = 0;
        for (; R < s.length(); R++) {
            char c = s.charAt(R);
            if (bits[c]) {
                //若已经存在,开始收缩L,收缩过程中经历的字符设置为false;
                for (; s.charAt(L) != c; L++) bits[s.charAt(L)] = false;
                L++;
            }
            bits[c] = true;
            result = Math.max(result, R - L + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        String target = "bbbbb";
        System.out.println(lengthOfLongestSubstring(target));
    }

}
