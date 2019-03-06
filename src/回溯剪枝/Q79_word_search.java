package 回溯剪枝;

public class Q79_word_search {
    boolean[][] gone;
    int[][] changes = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int m, n;

    public boolean exist(char[][] board, String word) {
        /**
         *  思想: 回溯剪枝,先找到第一个元素,然后开始DFS是否能匹配.若不存在,找一下出现的头元素,然后DFS
         */
        m = board.length;
        n = board[0].length;
        gone = new boolean[m][n];
        char[] chars = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != chars[0]) continue;
                gone[i][j] = true;
                boolean r = DFS(board, chars, 1, i, j);
                if (r) return true;
                gone[i][j] = false;
            }
        }
        return false;
    }

    private boolean DFS(char[][] board, char[] word, int index, int x, int y) {
        if (word.length == index) return true;
        //x,y为上一个点
        for (int[] change : changes) {
            int new_x = change[0] + x;
            int new_y = change[1] + y;
            if (new_x < 0 || new_x >= m || new_y < 0 || new_y >= n) continue;
            if (board[new_x][new_y] != word[index] || gone[new_x][new_y]) continue;
            gone[new_x][new_y] = true;
            boolean r = DFS(board, word, index + 1, new_x, new_y);
            gone[new_x][new_y] = false;
            if (r) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board =
                {
                        {'a', 'a'}
                };
        Q79_word_search s = new Q79_word_search();
        String str = "a";
        System.out.println(s.exist(board, str));

    }
}
