package KMP;

public class Q214_shortest_palindrome {


    public String shortestPalindrome(String s) {
        /**
         * 暴力添加: 新加字符串的上限是s[1:],每次加长度0,长度1,长度2,长度3..直到取完 每次验证一下新组成的,是否以反向的s开头
         * 经过验证: 这货过不了
         */
        if (s.length() == 0) return "";
        String I_s = new StringBuilder(s.substring(1)).reverse().toString();
        String I_s_1 = new StringBuilder(s).reverse().toString();
        for (int i = 0; i <= I_s_1.length(); i++) {
            String test = I_s_1.substring(0, i) + s;
            if (test.startsWith(I_s)) return test;
        }
        return "";
    }

    public String shortestPalindrome2(String s) {
        /*
       思入2: 从左到右找最长的回文串.然后右边剩下的部分就是左边所需的
       通过kmp的next数组来快速找到最长回文. 本来next是找重复的, 简单颠倒一下就变为回文了
        合成的字符串=正常字符#反转字符  next[-1]就是原串从左向右最长的回文串长度
         */
        String merge = s + "|" + new StringBuilder(s).reverse().toString();

        int[] next = new int[merge.length()];
        for (int i = 1, maxLen = 0; i < merge.length(); i++) {
            while (maxLen > 0 && merge.charAt(maxLen) != merge.charAt(i)) {
                maxLen = next[maxLen - 1];
            }
            if (merge.charAt(maxLen) == merge.charAt(i)) maxLen++;
            next[i] = maxLen;
        }

        String rest = new StringBuilder(s.substring(next[merge.length() - 1])).reverse().toString();
        return rest + s;
    }

    public static void main(String[] args) {
        Q214_shortest_palindrome s = new Q214_shortest_palindrome();
        String a = "abcd";
        System.out.println(s.shortestPalindrome2(a));
    }
}
