package 动态规划;

public class Q72_edit_distance {
    public int minDistance(String word1, String word2) {
        /*
        思入: 动态规划
        状态 dp[i][j]表示  S1[0,i]和S2[0,j]串之间的编辑距离
        状态转移方程:
        dp[i][j]=   if  S1[i] == S2[j]
                        min(dp[i-1][j-1],dp[i-1][j]+1,dp[i][j-1]+1)
                    else 替换
                        1+ min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]
         */
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];


        for (int i = 0; i <= len1; i++) {
            for (int j = 0; j <= len2; j++) {
                if (i == 0 || j == 0) dp[i][j] = Math.max(i, j);
                else {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];
                    else {
                        dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]);
                    }
                }

            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        String word1 = "intention", word2 = "execution";
        Q72_edit_distance solver = new Q72_edit_distance();
        System.out.println(solver.minDistance(word1, word2));
    }
}
