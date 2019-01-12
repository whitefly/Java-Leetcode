package 图形学;

import java.util.Arrays;

public class Q289_game_of_life {
    public void gameOfLife(int[][] board) {
        /**
         * 思入: 按题目思入来
         */

        int[][] changes = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        int m = board.length, n = board[0].length;
        int[][] clone = new int[m][n];
        for (int i = 0; i < m; i++) System.arraycopy(board[i], 0, clone[i], 0, n);


        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int count = 0;
                for (int[] change : changes) {
                    int new_x = change[0] + x, new_y = change[1] + y;
                    if (new_x < 0 || new_y < 0 || new_x >= m || new_y >= n) continue;
                    if (clone[new_x][new_y] == 1) count++;
                }
                //判断
                if (clone[x][y] == 1) {
                    if (count < 2 || count > 3) board[x][y] = 0;
                } else {
                    if (count == 3) board[x][y] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q289_game_of_life s = new Q289_game_of_life();
        int[][] nums = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        s.gameOfLife(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }

    }
}
