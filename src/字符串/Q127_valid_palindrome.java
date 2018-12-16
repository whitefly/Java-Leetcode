package 字符串;

public class Q127_valid_palindrome {
    /**
     * 思入: 双指针的思入, 字符串扫到非字符串知道跳过
     */

    private boolean is_char(char c) {
        return ('0' <= c && c <= '9') || ('a' <= c && c <= 'z');
    }

    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0, r = s.length() - 1;
        while (l < r) {
            //跳过非字符
            while (!is_char(s.charAt(l)) && l < r) l++;
            while (!is_char(s.charAt(r)) && l < r) r--;
            char c1 = s.charAt(l), c2 = s.charAt(r);
            if (l > r || c1 != c2) return false;
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q127_valid_palindrome s = new Q127_valid_palindrome();
        System.out.println(s.isPalindrome(""));
    }
}
