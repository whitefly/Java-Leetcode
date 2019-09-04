package 动态规划;

public class Q509_fibonacci_number {
    public int fib(int N) {
        /*
        思入:动态规划
         */
        int[] dp = new int[32];
        dp[1] = 1;
        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N];
    }
}
