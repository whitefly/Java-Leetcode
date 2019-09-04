package 动态规划;

public class Q516_longest_palindromic_subsequence {
    public int longestPalindromeSubseq(String s) {
        /*
        思入: 动态规划  dp[i][j] 表示 [i,j]最长的回文子序列
        若 num[i]==nums[j]
        dp[i][j]= dp[i+1][j-1] + 2
        若 nums[i]!=nums[i]
        dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
         */
        int[][] dp = new int[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < s.length(); j++) {
                if ((i + 1) == j) dp[i][j] = (chars[i] == chars[j]) ? 2 : 1;
                else {
                    if (chars[i] == chars[j]) dp[i][j] = dp[i + 1][j - 1] + 2;
                    else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        String str = "bbbab";
        Q516_longest_palindromic_subsequence s = new Q516_longest_palindromic_subsequence();
        System.out.println(s.longestPalindromeSubseq(str));
    }
}
