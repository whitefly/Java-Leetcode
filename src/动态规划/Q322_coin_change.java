package 动态规划;

import java.util.Arrays;

public class Q322_coin_change {
    private int[] dp;
    private int[] coins;

    public int coinChange(int[] coins, int amount) {
        /**
         * 动态规划: DAG求最短路径. DP[i]为 总面值为i时的硬币的最小组合数.
         * DP[i]=MAX{DP[j]+1|(i,j∈E)},  j为i的出边点集合. 注意不可达和为遍历到这2种状态
         * 方式: 记忆化+递归
         */
        dp = new int[amount + 1];
        this.coins = coins;
        Arrays.fill(dp, -1);
        int result = helper(amount);
        return result == (1 << 30) ? -1 : result;
    }

    private int helper(int S) {
        if (dp[S] != -1) return dp[S];   //-1表示没有算过 0表示不可达
        if (S == 0) return 0;
        int result = 1 << 30;
        for (int coin : coins) if (coin <= S) result = Math.min(result, helper(S - coin) + 1);
        return dp[S] = result;
    }

    public int coinChange2(int[] coins, int amount) {
        /**
         * 动态规划: 反向递推
         */
        int[] min = new int[amount + 1];  //设定min[0]=0;
        Arrays.fill(min, 1, amount + 1, Integer.MAX_VALUE - 1);
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    min[i] = Math.min(min[i], min[i - coin] + 1);
                }
            }
        }
        return min[amount] == (Integer.MAX_VALUE - 1) ? -1 : min[amount];
    }

    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Q322_coin_change s = new Q322_coin_change();
        System.out.println(s.coinChange2(coins, amount));

    }
}
