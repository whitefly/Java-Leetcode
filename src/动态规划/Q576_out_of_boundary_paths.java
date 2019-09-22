package 动态规划;

import java.util.Arrays;

public class Q576_out_of_boundary_paths {
    private int[][][] dp;
    private final int UNDO = -1;
    private int m;
    private int n;
    private int[][] changes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private void init() {
        for (int[][] sub : dp) for (int[] line : sub) Arrays.fill(line, UNDO);
    }

    public int findPaths(int m, int n, int N, int i, int j) {
        /*
        思入:  无特定反向的3维动态规划. dp[i][j][k]表示从(i,j)点出发,最多移动k次.的最大路径数.
        由于是无特定循环方向,所以使用 递归来完成动规的方向
         */
        this.m = m;
        this.n = n;
        dp = new int[m][n][N + 1];
        init();
        return getDp(i, j, N);
    }

    private int getDp(int i, int j, int k) {
        if (!valid(i, j)) return 1;
        if (dp[i][j][k] != UNDO) return dp[i][j][k];
        if (k == 0) return dp[i][j][k] = 0;
        else {
            int temp = 0;
            for (int[] change : changes) temp = (temp + getDp(i + change[0], j + change[1], k - 1)) % (1000000007);
            return dp[i][j][k] = temp;
        }
    }

    private boolean valid(int i, int j) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }

    public static void main(String[] args) {
//        int m = 2, n = 2, N = 2, i = 0, j = 0;
        int m = 8, n = 50, N = 23, i = 5, j = 26;
        Q576_out_of_boundary_paths s = new Q576_out_of_boundary_paths();
        System.out.println(s.findPaths(m, n, N, i, j));
    }
}
