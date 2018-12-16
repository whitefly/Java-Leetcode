package 字符串;

public class Q9_palindrome_number {
    public boolean isPalindrome(int x) {
        /**
         *思入: 题目要求不用使用字符串来完好该题,需要采用生成新数字比较的形式来完成
         * 1.负数绝对不可能是回文的
         * 2.直接反转一下,生成新数字
         */
        if (x < 0) return false;
        int old_n = x, new_n = 0;
        while (x != 0) {
            new_n = new_n * 10 + x % 10;
            x /= 10;
        }
        return old_n == new_n;
    }

    public static void main(String[] args) {
        Q9_palindrome_number s = new Q9_palindrome_number();
        int num = 121;
        System.out.println(s.isPalindrome(1011));

    }
}
