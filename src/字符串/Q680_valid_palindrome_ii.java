package 字符串;

public class Q680_valid_palindrome_ii {
    public boolean validPalindrome(String s) {
        int L = 0, R = s.length() - 1;
        while (L < R) {
            if (s.charAt(L) != s.charAt(R)) {
                return isPalindrome(s, L, R - 1) || isPalindrome(s, L + 1, R);
            }
            L++;
            R--;
        }
        return true;
    }


    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String target = "aba";
        String target2 = "abcaz";
        Q680_valid_palindrome_ii solver = new Q680_valid_palindrome_ii();
        System.out.println(solver.validPalindrome(target2));
    }
}
