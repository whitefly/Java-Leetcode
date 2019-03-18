package 双指针;

public class Q125_valid_palindrome {
    public boolean isPalindrome(String s) {
        /**
         * 思入: 设置双指针,比完后同时移动即可
         */
        int left = 0, right = s.length() - 1;
        s = s.toLowerCase();
        char[] chars = s.toCharArray();
        while (left < right) {
            while (!check(chars[left]) && left < right) left++;
            while (!check(chars[right]) && left < right) right--;
            if (left > right || chars[left] != chars[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    private boolean check(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    public static void main(String[] args) {
        String str = "race a car";
        Q125_valid_palindrome s = new Q125_valid_palindrome();
        System.out.println(s.isPalindrome(str));
    }
}
