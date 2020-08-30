package 动态规划;

import java.util.Arrays;

public class Q887_super_egg_drop {

    public static int superEggDrop(int K, int N) {
        int[][] dp = new int[K + 1][N + 1];

        //初始化
        for (int i = 0; i <= K; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        //k=0,1
        for (int i = 0; i <= N; i++) {
            dp[0][i] = 0;
            dp[1][i] = i;
        }
        // 和 n=0,1的时候
        for (int i = 0; i <= K; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int k = 2; k <= K; k++) {
            for (int n = 2; n <= N; n++) {
                for (int x = 1; x <= n; x++) {
                    dp[k][n] = Math.min(dp[k][n], Math.max(dp[k - 1][n - x], dp[k][x]) + 1);
                }
            }
        }
        return dp[K][N];
    }

    public static void main(String[] args) {
        int K = 2, N = 6;
        int i = superEggDrop(K, N);
        System.out.println(i);

    }
}
