package 动态规划;

public class Q70_climbing_stairs {
    static int[] dp = new int[10000];

    static {
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
    }

    static int size = 3;

    public int climbStairs(int n) {
        /**
         *思入: 动态规划 累积量 dp[i]=dp[i-1]+dp[i-2]
         */
        if (size - 1 >= n) return dp[n];
        else for (int i = size; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            size++;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q70_climbing_stairs s = new Q70_climbing_stairs();
        System.out.println(s.climbStairs(5));
    }
}
