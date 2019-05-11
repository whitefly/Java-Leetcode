package 动态规划;

import java.util.Arrays;

public class Q518_coin_change_2 {
    public int change(int amount, int[] coins) {
        /**
         * 思入: 动态规划,反向递推
         */
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        return dp[amount];
    }
}
