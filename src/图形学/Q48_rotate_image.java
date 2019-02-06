package 图形学;

import java.util.Arrays;

public class Q48_rotate_image {
    public void rotate(int[][] matrix) {
        /**
         *  思入:  使用对角线对称 和 中线对称来完成 顺时针旋转90度.
         *  步骤1: 对角线镜像,
         *  步骤2:  中线对称
         */
        int n = matrix.length;
        int half = n / 2;
        //对角交换
        for (int i = 0; i < n; i++) for (int j = 0; j < i; j++) swap(matrix, i, j, j, i);
        //中线交换
        for (int i = 0; i < n; i++) for (int j = 0; j < half; j++) swap(matrix, i, j, i, n - j - 1);
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        System.out.printf("%d-%d,%d-%d\n", i1, j1, i2, j2);
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }

    private void show(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Q48_rotate_image s = new Q48_rotate_image();
        s.rotate(nums);
    }
}
