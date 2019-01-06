package 图论;

import java.util.LinkedList;
import java.util.Queue;

public class Q200_number_of_islands {
    private int[][] changes = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    class point {
        int x;
        int y;

        point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public int numIslands(char[][] grid) {
        /**
         *  思入: 广度优先. 遍历属于一个集合的点
         */
        if (grid.length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        boolean[][] gone = new boolean[m][n];
        Queue<point> Q = new LinkedList<>();
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (gone[i][j] || grid[i][j] == '0') continue;
                result++;
                Q.offer(new point(i, j));
                gone[i][j] = true;
                BFS(grid, gone, Q);
            }

        }
        return result;
    }

    private void BFS(char[][] grid, boolean[][] gone, Queue<point> Q) {
        int m = grid.length, n = grid[0].length;
        while (!Q.isEmpty()) {
            point temp = Q.poll();
            for (int[] change : changes) {
                int new_x = change[0] + temp.x;
                int new_y = change[1] + temp.y;
                if (new_x < 0 || new_y < 0 || new_x >= m || new_y >= n) continue;
                if (gone[new_x][new_y] || grid[new_x][new_y] == '0') continue;

                Q.offer(new point(new_x, new_y));
                gone[new_x][new_y] = true;
            }
        }
    }
}
