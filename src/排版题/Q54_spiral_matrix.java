package 排版题;

import java.util.ArrayList;
import java.util.List;

public class Q54_spiral_matrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        /**
         * 思入: 找准初始位置(2个角点),然后一圈一圈遍历(上,右,下,左),防止变为单条 or 单竖
         */
        ArrayList<Integer> result = new ArrayList<>();
        if (matrix.length == 0) return result;
        for (int i1 = 0, j1 = 0, i2 = matrix.length - 1, j2 = matrix[0].length - 1; i1 <= i2 && j1 <= j2; i1++, j1++, i2--, j2--) {
            if (i1 < i2 && j1 < j2) {
                //假设非单条
                //上
                for (int j = j1; j < j2; j++) result.add(matrix[i1][j]);
                //右
                for (int i = i1; i < i2; i++) result.add(matrix[i][j2]);
                //下
                for (int j = j2; j > j1; j--) result.add(matrix[i2][j]);
                //左
                for (int i = i2; i > i1; i--) result.add(matrix[i][j1]);
            } else {
                //单条
                if (i1 == i2) for (int j = j1; j <= j2; j++) result.add(matrix[i1][j]); //横
                else for (int i = i1; i <= i2; i++) result.add(matrix[i][j1]);  //竖
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums =
                {{3}, {2}};
        Q54_spiral_matrix s = new Q54_spiral_matrix();
        List<Integer> integers = s.spiralOrder(nums);
        System.out.println(integers);

    }
}
