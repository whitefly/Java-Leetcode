package KMP;

import java.util.Arrays;

public class KMP实现 {

    int search(String text, String pat) {
        int[] prefix = getPrefix(pat);

        int count = 0;  //当前匹配的个数
        for (int i = 0; i < text.length(); i++) {
            //i为母字符串的指针,不会回退
            while (count > 0 && pat.charAt(count) != text.charAt(i)) {
                count = prefix[count - 1];
            }
            if (pat.charAt(count) == text.charAt(i)) count++;

            if (count == pat.length()) return i - pat.length() + 1;
        }
        return -1;
    }


    int[] getPrefix(String pattern) {
        char[] chars = pattern.toCharArray();
        int[] prefix = new int[pattern.length()];

        for (int i = 1, maxLen = 0; i < pattern.length(); i++) {
            while (maxLen > 0 && chars[i] != chars[maxLen]) {
                maxLen = prefix[maxLen - 1];  //减少长度,继续匹配可能的
            }
            if (chars[i] == chars[maxLen]) maxLen++;  //要不maxLen已经为0,要不出现了相等

            prefix[i] = maxLen;
        }
        return prefix;
    }

    public static void main(String[] args) {
        String all = "1112ababcdabcd";
        String taregt = "abcabcabcabc";
        KMP实现 s = new KMP实现();
//        System.out.println(s.search(all, taregt));
        System.out.println(Arrays.toString(s.getPrefix(taregt)));
        System.out.println(s.search(all, taregt));
    }

}



