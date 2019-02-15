package 动态规划;

public class Q62_unique_paths {
    public int uniquePaths(int m, int n) {
        /**
         * 思入: 动态规划,状态:达到该点的所有不同的路径, dp[i][j]=dp[i-1][j]+dp[i][j-1]
         * 从左向右,从上到下遍历
         */

        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i==0 && j==0)dp[i][j]=1;
                else {
                   int left= i-1<0?0:dp[i-1][j];
                   int right= j-1<0?0:dp[i][j-1];
                   dp[i][j]=left+right;
                }
            }
        }
        return  dp[m-1][n-1];
    }

    public static void main(String[] args) {
        Q62_unique_paths s = new Q62_unique_paths();
        int i = s.uniquePaths(7, 3);
        System.out.println(i);
    }
}
