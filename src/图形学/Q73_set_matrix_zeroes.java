package 图形学;

public class Q73_set_matrix_zeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) return;
        int m = matrix.length, n = matrix[0].length;
        boolean[] row_id = new boolean[m];
        boolean[] col_id = new boolean[n];
        //得到空行的行号 和 列号
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    row_id[i] = true;
                    col_id[j] = true;
                }
            }
        }
        //开始置0
        for (int i = 0; i < m; i++) if (row_id[i]) for (int j = 0; j < n; j++) matrix[i][j] = 0;
        for (int j = 0; j < n; j++) if (col_id[j]) for (int i = 0; i < m; i++) matrix[i][j] = 0;
    }
}
