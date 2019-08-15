package 排版题;

import java.util.Arrays;

public class Q498_diagonal_traverse {
    private int limitX;
    private int limitY;

    public int[] findDiagonalOrder(int[][] matrix) {
        /*
        思入1: 记录每轮的最后一个元素
         */
        if (matrix.length == 0) return new int[0];
        int size = matrix.length * matrix[0].length;
        int[] result = new int[size];
        int count = 0;
        limitX = matrix.length - 1;
        limitY = matrix[0].length - 1;
        int[] position = {0, 0};
        boolean direct = true;  //true表示斜上方移动

        while (true) {
            result[count++] = matrix[position[0]][position[1]];
            if (count >= size) break;

            if (direct) {
                up(position);
                if (!check(position)) {
                    position[0]++;
                    while (!check(position)) down(position);
                    direct = false;
                }
            } else {
                down(position);
                if (!check(position)) {
                    position[1]++;
                    while (!check(position)) up(position);
                    direct = true;
                }
            }
        }
        return result;
    }

    private void up(int[] position) {
        position[0]--;
        position[1]++;
    }


    private void down(int[] position) {
        position[0]++;
        position[1]--;
    }

    private boolean check(int[] position) {
        return position[0] >= 0 && position[0] <= limitX && position[1] >= 0 && position[1] <= limitY;
    }

    public static void main(String[] args) {
        int[][] nums = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Q498_diagonal_traverse s = new Q498_diagonal_traverse();
        int[] diagonalOrder = s.findDiagonalOrder(nums);
        System.out.println(Arrays.toString(diagonalOrder));

    }
}

