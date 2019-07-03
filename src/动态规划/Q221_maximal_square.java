package 动态规划;

public class Q221_maximal_square {
    public int maximalSquare(char[][] matrix) {
        /**
         * 思入: 动态规划: 以(i,j)为右下角(包含)的最大边长
         * dp[i][j]= min(dp[i-1][j],dp[i][j-1])+1 if nums[i][j]=0  else  0
         */
        int slide = 0;
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') continue;
                if (i == 0 || j == 0) dp[i][j] = 1;
                else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                    dp[i][j] = (dp[i][j] == 2 && matrix[i - 1][j - 1] == '0') ? 1 : dp[i][j];
                }

                slide = Math.max(slide, dp[i][j]);
//                System.out.println("(" + i + "," + j + "):" + dp[i][j]);
            }
        }
        return slide * slide;
    }

    public static void main(String[] args) {
        char[][] nums = {
                {'1', '0', '1', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
                {'1', '1', '1', '1'}};
//        char[][] nums = {{'0', '1'}, {'0', '1'}};
        Q221_maximal_square s = new Q221_maximal_square();
        int k = s.maximalSquare(nums);
        System.out.println(k);
    }
}
