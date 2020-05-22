package 剑指Offer;

public class O12_ju_zhen_zhong_de_lu_jing_lcof {

    boolean[][] gone;

    int[][] changes = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int limitX, limitY;

    public boolean exist(char[][] board, String word) {
        limitX = board.length;
        limitY = board[0].length;
        gone = new boolean[limitX][limitY];
        char[] target = word.toCharArray();
        for (int i = 0; i < limitX; i++) {
            for (int j = 0; j < limitY; j++) {
                boolean rnt = helper(board, target, 0, i, j);
                if (rnt) return true;
            }
        }
        return false;
    }

    public boolean helper(char[][] board, char[] chars, int index, int x, int y) {
        if (index >= chars.length) return true;
        if (limitX <= x || x < 0 || y < 0 || limitY <= y || gone[x][y]) return false;
        boolean result = false;
        if (board[x][y] == chars[index]) {
            gone[x][y] = true;
            for (int[] change : changes) {
                if (helper(board, chars, index + 1, x + change[0], y + change[1])) {
                    result = true;
                    break;
                }
            }
            //开始遍历周围
            gone[x][y] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] chars = {{'a', 'b'}, {'c', 'd'}};
        O12_ju_zhen_zhong_de_lu_jing_lcof s = new O12_ju_zhen_zhong_de_lu_jing_lcof();
        System.out.println(s.exist(chars, "ab"));
    }
}
