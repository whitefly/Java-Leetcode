package 动态规划;

import java.util.Arrays;

public class Q279_perfect_squares {
    public int numSquares(int n) {
        /*
        思入: 和换零钱那题很像. 只不过将面值变为完全平方数.
        dp[i]表示 凑成i的最小组合数
         */
        int[] dp = new int[n + 1];
        int BIG = 9999999;
        Arrays.fill(dp, 1, dp.length, BIG);
        for (int i = 1; i <= n; i++) {
            for (int j = 1, temp; (temp = (i - j * j)) >= 0; j++) {
                dp[i] = Math.min(dp[temp] + 1, dp[i]);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q279_perfect_squares s = new Q279_perfect_squares();
        System.out.println(s.numSquares(2));
    }
}
