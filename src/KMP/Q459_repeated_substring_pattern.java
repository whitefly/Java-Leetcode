package KMP;

public class Q459_repeated_substring_pattern {
    public boolean repeatedSubstringPattern(String s) {
        char[] chars = s.toCharArray();
        int[] prefix = new int[s.length()];
        int len = s.length();
        for (int i = 1, maxLen = 0; i < len; i++) {
            while (maxLen > 0 && chars[i] != chars[maxLen]) {
                maxLen = prefix[maxLen - 1];  //减少长度,继续匹配可能的
            }
            if (chars[i] == chars[maxLen]) maxLen++;  //要不maxLen已经为0,要不出现了相等

            prefix[i] = maxLen;
        }
        int left = len - prefix[len - 1];
        return prefix[len - 1] != 0 && len % left == 0;
    }

    public static void main(String[] args) {
        String target = "abab";
        Q459_repeated_substring_pattern s = new Q459_repeated_substring_pattern();
        System.out.println(s.repeatedSubstringPattern(target));
    }

}
