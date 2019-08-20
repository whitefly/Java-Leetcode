package 动态规划;

import java.util.Arrays;

public class Q329_longest_increasing_path_in_a_matrix {
    private int result = 0;
    private int limitX, limitY;
    private int[][] matrix;
    private int[][] dp;
    private final int unArrived = -1000000;

    public int longestIncreasingPath(int[][] matrix) {
        /*
           思入: 动态规划. dp[i][j]表示作为末尾的最长路径数
           dp[i][j]=  Max(dp[i-1][j],dp[i+1][j],dp[i][j-1],dp[i][j])
          由于是向四面扩散的.所以没有一个固定的循环方向,所以尝试用 递归(黑话叫记忆化搜索)来解题
         */
        if (matrix.length == 0) return 0;
        this.matrix = matrix;
        dp = new int[matrix.length][matrix[0].length];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        limitX = matrix.length - 1;
        limitY = matrix[0].length - 1;

        for (int i = 0; i <= limitX; i++) {
            for (int j = 0; j <= limitY; j++) result = Math.max(helper(i, j), result);
        }
        return result;
    }

    private int helper(int i, int j) {
        if (dp[i][j] != -1) return dp[i][j];
        int up = unArrived, down = unArrived, left = unArrived, right = unArrived;
        if (i >= 1 && matrix[i - 1][j] < matrix[i][j]) up = helper(i - 1, j);
        if (j >= 1 && matrix[i][j - 1] < matrix[i][j]) left = helper(i, j - 1);
        if (i < limitX && matrix[i + 1][j] < matrix[i][j]) down = helper(i + 1, j);
        if (j < limitY && matrix[i][j + 1] < matrix[i][j]) right = helper(i, j + 1);
        return dp[i][j] = max(up, left, down, right, 0) + 1;
    }

    private int max(int... nums) {
        int temp = Integer.MIN_VALUE;
        for (int num : nums) temp = Math.max(num, temp);
        return temp;
    }

    public static void main(String[] args) {
//        int[][] nums = {
//                {9, 9, 4},
//                {6, 6, 8},
//                {2, 1, 1}};

        int[][] nums = {
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}};

        Q329_longest_increasing_path_in_a_matrix s = new Q329_longest_increasing_path_in_a_matrix();
        int i = s.longestIncreasingPath(nums);
        System.out.println(i);

    }


}
