package 哈希;

import java.util.ArrayList;
import java.util.Arrays;

public class Q36_valid_sudoku {
    public boolean isValidSudoku(char[][] board) {
        /**
         * 思入: 用数组hash来判断是否第一次出现. 行判断,列判断,块判断
         */

        int[][] hashs = new int[2][128];
        int n = 9;
        //行,列同时判断
        for (int i = 0; i < n; i++) {
            for (int[] hash : hashs) Arrays.fill(hash, 0);//初始化
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {//先行,后列
                    char c = (k == 0) ? board[i][j] : board[j][i];
                    if (c == '.') continue;
                    if (hashs[k][c] == 1) return false;
                    hashs[k][c] = 1;
                }
            }
        }
        //块判断
        int[] hash = hashs[0];
        Arrays.fill(hash, 0);
        int[][] centers = {{1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7}};
        int[][] changes = {{0, 0}, {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
        for (int[] point : centers) {
            Arrays.fill(hash, 0);
            for (int[] change : changes) {
                int new_x = point[0] + change[0];
                int new_y = point[1] + change[1];
                char c = board[new_x][new_y];
                if (c == '.') continue;
                if (hash[c] == 1) return false;
                hash[c] = 1;
            }
        }
        return true;
    }
}
