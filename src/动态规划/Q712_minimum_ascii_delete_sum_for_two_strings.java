package 动态规划;

public class Q712_minimum_ascii_delete_sum_for_two_strings {
    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    dp[i][j] = dp[i][j - 1] + s2.charAt(j - 1);
                } else if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + s1.charAt(i - 1);
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else {
                        dp[i][j] = Math.min(dp[i - 1][j] + s1.charAt(i - 1), dp[i][j - 1] + s2.charAt(j - 1));
                    }
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String s1 = s1 = "delete", s2 = "leet";
        Q712_minimum_ascii_delete_sum_for_two_strings s = new Q712_minimum_ascii_delete_sum_for_two_strings();
        int i = s.minimumDeleteSum(s1, s2);
        System.out.println(i);
    }
}
