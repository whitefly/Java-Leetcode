package 动态规划;

public class Q343_integer_break {
    public int integerBreak(int n) {
        /*
         思入; 和完全背包很相似的 普通动态规划问题
         思入: dp[i]表示 和凑成i的最大乘积
         dp[i]= max(dp[i-1],dp[i-2],dp[i-3]...dp[2])
         */
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; (i - j) >= 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];


    }

    public static void main(String[] args) {
        Q343_integer_break s = new Q343_integer_break();
        int i = s.integerBreak(10);
        System.out.println(i);
    }
}
