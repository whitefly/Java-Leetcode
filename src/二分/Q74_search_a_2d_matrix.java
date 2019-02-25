package 二分;

public class Q74_search_a_2d_matrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        /**
         * 思入: 矩阵的二分搜索. 选择左下角作为初始点,不断向上 or 向右来缩小范围
         */
        if (matrix.length == 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int x = m - 1, y = 0;
        while (0 <= x && y < n) {
            int num = matrix[x][y];
            if (num == target) return true;
            if (num > target) x--;
            else y++;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        Q74_search_a_2d_matrix s = new Q74_search_a_2d_matrix();
        boolean b = s.searchMatrix(nums, 3);
        System.out.println(b);
    }

    
}
