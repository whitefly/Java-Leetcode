package 动态规划;

public class Q419_battleships_in_a_board {
    public int countBattleships(char[][] board) {
        /*
        思入: 动态规划 dp[i][j]表示从 (0,0)->(i,j)含有的战舰个数
        dp[i][j]=  前一个 +  board[i][j-1]==空 && board[i-1][j]==空?1:0
        由于只需要前几个,所以讲dp[i][j] 优化为 只保留前一个dp即可
         */
        int dp = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X' && (j == 0 || board[i][j - 1] == '.') && (i == 0 || board[i - 1][j] == '.')) {
                    dp++;
                }
            }
        }
        return dp;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'}};
        Q419_battleships_in_a_board s = new Q419_battleships_in_a_board();
        System.out.println(s.countBattleships(board));
    }
}
