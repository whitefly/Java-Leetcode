package 背包问题;

import java.util.Arrays;
import java.util.Map;

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
         * 动态规划: 反向递推.
         * 状态为DP[i]为 总面值为i时的硬币的最小组合数. 是一个1维dp, 这种思想仅仅是普通动态规划,并不是背包问题的做法. 状态表面上看起来相同,代码形式有点类似01背包,但是本质完全不同
         */
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];  //设定min[0]=0;
        Arrays.fill(dp, 1, amount + 1, Integer.MAX_VALUE - 1);
        for (int i = 1; i <= amount; i++) {
            int thisMin = dp[i];
            for (int coin : coins) {
                if (coin <= i) thisMin = Math.min(thisMin, dp[i - coin] + 1);
                else break;
            }
            dp[i] = thisMin;
        }
        return dp[amount] == (Integer.MAX_VALUE - 1) ? -1 : dp[amount];
    }

    public int coinChange3(int[] coins, int amount) {
        /*
        思入3: 纯完全背包问题+空间优化,硬币面值为重量,每个硬币价值为1,背包重量为amount,求最小总价值, 必须装满(所以需要设置∞来表示不可达状态)
        完全背包的本质是一个二维dp. 虽然空间优化成一维,但是状态的含义是2维的.注意和上面一维动规思想一定要区别.
         */
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, 1, dp.length, 9999999); //9999999表示不可达
        for (int coin : coins) {
            int count = amount / coin;
            for (int k = 0; k < count; k++) {
                for (int j = amount; j >= 1; j--) {
                    dp[j] = (j - coin) >= 0 ? Math.min(dp[j], dp[j - coin] + 1) : dp[j];
                }
            }
        }
        return dp[amount] == 9999999 ? -1 : dp[amount];
    }


    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        Q322_coin_change s = new Q322_coin_change();
        System.out.println(s.coinChange3(coins, amount));

    }
}
