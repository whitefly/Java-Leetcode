package 图形学;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q130_surrounded_regions {
    private final int[][] changes = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public void solve(char[][] board) {
        /**
         *  思入: 本质就是从边界出发的'0'联通的区域保持原样,然后地方设置为"X"
         *  实现: 从边界出发,与边界联通的区域设置一个flag位,表示最终要维持原值,然后碰到flag或者X就跳过,知道将边界扫完.
         *  最后再扫一遍,将没有设置flag位的o区域设置为X
         */
        if (board == null || board.length == 0) return;
        int m = board.length, n = board[0].length;
        boolean[][] flag = new boolean[m][n];
        //只扫边界
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == (m - 1) || j == 0 || j == (n - 1)) {
                    if (board[i][j] == 'X' || flag[i][j]) continue;
                    q.offer(new int[]{i, j});
                    flag[i][j] = true;
                    while (!q.isEmpty()) {
                        int[] position = q.poll();
                        int x = position[0];
                        int y = position[1];
                        for (int[] change : changes) {
                            int newX = x + change[0];
                            int newY = y + change[1];
                            if (newX < 0 || newX >= m || newY < 0 || newY >= n) continue;
                            if (board[newX][newY] == 'X' || flag[newX][newY]) continue;
                            flag[newX][newY] = true;
                            q.offer(new int[]{newX, newY});
                        }
                    }

                }
            }
        }
        //重新赋值
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'X' || flag[i][j]) continue;
                board[i][j] = 'X';
            }
        }
    }

    public static void main(String[] args) {
//        char[][] nums = {{'X', 'X', 'X', 'X'},
//                {'X', 'O', 'O', 'X'},
//                {'X', 'X', 'O', 'X'},
//                {'X', 'O', 'X', 'X'}
//        };
        char[][] nums = {
                {'O', 'O'},
                {'O', 'O'}
        };
        Q130_surrounded_regions s = new Q130_surrounded_regions();
        s.solve(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(nums[i]));
        }
    }
}
