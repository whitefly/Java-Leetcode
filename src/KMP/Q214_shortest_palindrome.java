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

    public static void main(String[] args) {
        Q214_shortest_palindrome s = new Q214_shortest_palindrome();
        String a = "";
        System.out.println(s.shortestPalindrome(a));

    }
}
