package 背包问题;

import java.util.Arrays;

public class 背包01 {

    public void solver() {
        int[] w = {0, 1, 1, 2, 2};
        int[] values = {0, 1, 2, 4, 5};
        int W = 4;
        int[][] dp = new int[w.length][W + 1];
        for (int j = 1; j <= W; j++) dp[0][j] = -10000;
        for (int i = 1; i < w.length; i++) {
            for (int j = 1; j <= W; j++) {
                dp[i][j] = (j - w[i] >= 0) ? Math.max(dp[i - 1][j], dp[i - 1][j - w[i]] + values[i]) : dp[i - 1][j];
            }
        }

        for (int[] ints : dp) System.out.println(Arrays.toString(ints));
    }

    public void solver2() {
        /*
        空间优化:  要需求方向同向遍历
         */
        int[] w = {0, 1, 1, 2, 2};
        int[] values = {0, 1, 2, 4, 5};
        int W = 4;
        int[] dp = new int[W + 1];
        for (int j = 1; j <= W; j++) dp[j] = -10000; //初始化(不可达)
        for (int i = 1; i < w.length; i++) {
            for (int j = W; j >= 1; j--) {
                dp[j] = (j - w[i] >= 0) ? Math.max(dp[j], dp[j - w[i]] + values[i]) : dp[j];
            }
        }
    }

    public static void main(String[] args) {
        背包01 s = new 背包01();
        s.solver();
        System.out.println();
        s.solver2();
    }


}
