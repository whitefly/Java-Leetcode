package 动态规划;

public class Q647_palindromic_substrings {
    public int countSubstrings(String s) {
        /*
        思入: 本质是最长回文子串.
        计算dp[i][j] 为true的个数
         */

        boolean[] dp = new boolean[s.length()];
        char[] chars = s.toCharArray();
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                if (i == j) dp[j] = true;
                else if (i + 1 == j) dp[j] = chars[i] == chars[j];
                else dp[j] = (chars[i] == chars[j]) && dp[j - 1];

                if (dp[j]) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "aaa";
        Q647_palindromic_substrings s = new Q647_palindromic_substrings();
        System.out.println(s.countSubstrings(str));
    }
}
