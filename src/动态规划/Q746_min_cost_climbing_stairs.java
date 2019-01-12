package 动态规划;

public class Q746_min_cost_climbing_stairs {

    public int minCostClimbingStairs(int[] cost) {
        /**
         *思入: dp[i]为达到该阶所需要的体力和
         * dp[i]=min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2])
         */
        int n = cost.length;
        int[] dp = new int[cost.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++) dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        return dp[n];
    }

    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        Q746_min_cost_climbing_stairs s = new Q746_min_cost_climbing_stairs();
        int i = s.minCostClimbingStairs(cost);
        System.out.println(i);

    }
}
