package 剑指Offer;

public class O47_li_wu_de_zui_da_jie_zhi_lcof {
    public int maxValue(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        //二位dp问题 dp[i][j]表示达到(i,j)时最高可以拿到的价值
        int cols = grid[0].length;
        int[] dp = new int[cols];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < cols; j++) {
                if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    dp[j] = Math.max(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }
        return dp[cols - 1];
    }

}
