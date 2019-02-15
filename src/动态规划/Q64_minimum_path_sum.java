package 动态规划;

public class Q64_minimum_path_sum {
    public int minPathSum(int[][] grid) {
        /**
         * 思入: 动态规则 状态: 从上 or 左 到达时,  最小的路径和(包括本身).   dp[i][j]= max(dp[i-1][j],dp[i][j-1])+grid[i][j];
         */
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        int left, up;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) dp[i][j] = grid[i][j];
                else {
                    up = i - 1 < 0 ? Integer.MAX_VALUE : dp[i - 1][j];
                    left = j - 1 < 0 ? Integer.MAX_VALUE : dp[i][j - 1];
                    dp[i][j] = Math.min(up, left) + grid[i][j];
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        Q64_minimum_path_sum s = new Q64_minimum_path_sum();
        int i = s.minPathSum(nums);
        System.out.println(i);
    }
}
