package 回溯剪枝;

import java.util.ArrayList;
import java.util.Arrays;

public class Q37_sudoku_solver {
    /**
     * 思入:  回溯剪枝. 每次走一步有9种可能,需要一个有效性数组
     */
    boolean[][] row_hash = new boolean[9][10];
    boolean[][] col_hash = new boolean[9][10];
    boolean[][][] block_hash = new boolean[3][3][10];  //block_hash是本题核心
    char[][] copy = new char[9][9];
    char[][] r;
    boolean end = false;
    ArrayList<Integer[]> points = new ArrayList<>();

    public void solveSudoku(char[][] board) {
        r = board;
        for (int i = 0; i < 9; i++) System.arraycopy(board[i], 0, copy[i], 0, 9);
        //找出需要填充的所有点,并初始化3个hash表
        init(board);
        // BFS
        help(copy, 0);
    }

    private void help(char[][] board, int index) {
        if (end) return;
        //终止条件
        if (index == points.size()) {
            end = true;
            for (int i = 0; i < 9; i++) System.arraycopy(board[i], 0, r[i], 0, 9);
            return;
        }
        //开始填充对应点,回溯剪枝的模板代码
        Integer[] temp_p = points.get(index);
        int x = temp_p[0];
        int y = temp_p[1];
        for (int val = 1; val <= 9; val++) {
            if (!isValid(x, y, val)) continue;
            board[x][y] = (char) ('0' + val);
            update(x, y, val);
            help(board, index + 1);
            board[x][y] = '.';
            back(x, y, val);
        }
    }

    private boolean isValid(int x, int y, int val) {
        //行,列判断
        if (row_hash[x][val]) return false;
        if (col_hash[y][val]) return false;
        //块判断
        int block_x = x / 3;
        int block_y = y / 3;
        if (block_hash[block_x][block_y][val]) return false;
        return true;
    }

    private void update(int x, int y, int val) {
        set_value(x, y, val, true);
    }

    private void back(int x, int y, int val) {
        set_value(x, y, val, false);
    }

    private void set_value(int x, int y, int val, boolean flag) {
        row_hash[x][val] = flag;
        col_hash[y][val] = flag;
        int block_x = x / 3;
        int block_y = y / 3;
        block_hash[block_x][block_y][val] = flag;
    }

    private void init(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    Integer[] temp = {i, j};
                    points.add(temp);
                    continue;
                }
                int num = board[i][j] - '0';
                row_hash[i][num] = true;
                col_hash[j][num] = true;
                int block_x = i / 3;
                int block_y = j / 3;
                block_hash[block_x][block_y][num] = true;
            }
        }
    }

    public static void main(String[] args) {
        char[][] demo = {
                {'.', '.', '.', '.', '.', '.', '.', '.', '7'},
                {'.', '.', '2', '.', '.', '.', '.', '1', '.'},
                {'.', '.', '4', '5', '3', '.', '.', '.', '.'},
                {'.', '.', '.', '1', '.', '.', '.', '4', '.'},
                {'8', '7', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '6', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '7', '8', '.', '.', '.'},
                {'.', '.', '1', '.', '.', '.', '.', '2', '.'}};
        Q37_sudoku_solver s = new Q37_sudoku_solver();
        s.solveSudoku(demo);

        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(demo[i]));
        }
    }


}
