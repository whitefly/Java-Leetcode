package 动态规划;

public class Q63_unique_paths_ii {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        /**
         *  思入: 动态规则  状态: 到该位置有多少种状态   dp[i][j]= dp[i-1][j]+dp[i][j-1]
         *  前提: 左,上对应的状态有值,则不是障碍. 碰到障碍,则默认当做0
         */
        int m=obstacleGrid.length ,n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)return 0;  //防止 起点 or 终点 是石头
        int[][] dp= new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                 if(i==0&&j==0)dp[i][j]=1;
                 else {
                 int up= (i-1<0 || obstacleGrid[i-1][j]==1)?0:dp[i-1][j];
                 int left= (j-1<0 || obstacleGrid[i][j-1]==1)?0:dp[i][j-1];
                 dp[i][j]=up+left;
                 }
            }
        }
        return  dp[m-1][n-1];
    }

    public static void main(String[] args) {
        int[][] nums={
                {0,0,0},
                {0,1,0},
                {0,0,0}
        };

        Q63_unique_paths_ii s = new Q63_unique_paths_ii();
        int i = s.uniquePathsWithObstacles(nums);
        System.out.println(i);

    }
}
