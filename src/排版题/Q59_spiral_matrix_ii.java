package 排版题;

import java.util.Arrays;

public class Q59_spiral_matrix_ii {
    public int[][] generateMatrix(int n) {
        /**
         *
         */
        int[][] result = new int[n][n];
        int id = 1;
        for (int i = n - 1, x = 0, y = 0; i >= 0; i -= 2, x++, y++) {
            if (i == 0) result[x][y] = id;
            //上
            for (int delta = 0; delta < i; delta++, id++) result[x][y + delta] = id;
            //右
            for (int delta = 0; delta < i; delta++, id++) result[x + delta][y + i] = id;
            //下
            for (int delta = 0; delta < i; delta++, id++) result[x + i][y + i - delta] = id;
            //左
            for (int delta = 0; delta < i; delta++, id++) result[x + i - delta][y] = id;
        }
        return result;
    }

    public static void main(String[] args) {
        Q59_spiral_matrix_ii s = new Q59_spiral_matrix_ii();
        int[][] ints = s.generateMatrix(4);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }

    }
}
