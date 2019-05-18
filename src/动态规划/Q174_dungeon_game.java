package 动态规划;

import java.util.Arrays;

public class Q174_dungeon_game {
    int[][] dp;
    int m;
    int n;

    public int calculateMinimumHP(int[][] dungeon) {
        /**
         * 动态规划的递归版. dp[i][j]表示从该点出发后到终点,所需要的最小生命值
         */
        m = dungeon.length;
        n = dungeon[0].length;
        dp = new int[m][n];
        for (int[] row : dp) Arrays.fill(row, Integer.MIN_VALUE);
        return helper(dungeon, 0, 0);
    }

    public int helper(int[][] dungeon, int i, int j) {
        if (i == (m - 1) && j == (n - 1)) return dungeon[i][j] > 0 ? 1 : -dungeon[i][j] + 1;
        if (i >= m || j >= n) return Integer.MAX_VALUE;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        //右 or 右下
        int min = Math.min(helper(dungeon, i + 1, j), helper(dungeon, i, j + 1));
        return dp[i][j] = (dungeon[i][j] >= min) ? 1 : min - dungeon[i][j];
    }

    public static void main(String[] args) {
//        int[][] nums = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        int[][] nums = {{0, 0}};
        Q174_dungeon_game s = new Q174_dungeon_game();
        System.out.println(s.calculateMinimumHP(nums));
    }
}
