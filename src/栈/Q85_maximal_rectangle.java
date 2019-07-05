package 栈;

import java.util.Stack;

public class Q85_maximal_rectangle {
    public int maximalRectangle(char[][] matrix) {
        /**
         * 思入: 直方图中的最大长方形的变种.先得到一个直方图矩阵,然后每次调用的直方图矩阵算法
         */
        //构造直方图数值矩阵
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        int[][] nums = new int[m][n + 1];
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int up = (i == 0) ? 0 : nums[i - 1][j];
                if (matrix[i][j] == '1') nums[i][j] = up + 1;
            }
            result = Math.max(helper(nums[i]), result);
        }
        return result;
    }

    private int helper(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                Integer top = stack.pop();
                int leftMost = stack.empty() ? -1 : stack.peek();
                int rightMost = i;
                result = Math.max(result, heights[top] * (rightMost - leftMost + 1 - 2));
            }
            stack.push(i);
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        Q85_maximal_rectangle s = new Q85_maximal_rectangle();
        int i = s.maximalRectangle(matrix);
        System.out.println(i);
    }


}
