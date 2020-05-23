package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O29_shun_shi_zhen_da_yin_ju_zhen_lcof {


    static public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return new int[0];
        int width = matrix[0].length;
        int height = matrix.length;
        int startX = 0, startY = 0;
        List<Integer> result = new ArrayList<>();
        while (width > 0 && height > 0) {
            edge(matrix, width, height, startX, startY, result);
            width -= 2;
            height -= 2;
            startX++;
            startY++;
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    static List<Integer> edge(int[][] matrix, int width, int height, int startX, int startY, List<Integer> list) {
        //单边
        if (width == 1) {
            for (int i = 0; i < height; i++, startX++) {
                list.add(matrix[startX][startY]);
            }
        } else if (height == 1) {
            for (int i = 0; i < width; i++, startY++) {
                list.add(matrix[startX][startY]);
            }
        } else {
            //上
            for (int i = 0; i < width - 1; i++, startY++) list.add(matrix[startX][startY]);
            //右
            for (int i = 0; i < height - 1; i++, startX++) list.add(matrix[startX][startY]);
            //下
            for (int i = 0; i < width - 1; i++, startY--) list.add(matrix[startX][startY]);
            //左
            for (int i = 0; i < height - 1; i++, startX--) list.add(matrix[startX][startY]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}};
        int[] ints = spiralOrder(nums);
        System.out.println(Arrays.toString(ints));
        ArrayList<Object> objects = new ArrayList<>();
    }


}
