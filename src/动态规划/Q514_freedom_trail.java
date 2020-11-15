package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Q514_freedom_trail {
    public int findRotateSteps(String ring, String key) {
        //记录key的字母,在ring出现的位置
        int ban = 1000000;
        char[] rings = ring.toCharArray();
        char[] keys = key.toCharArray();
        ArrayList<Integer>[] pos = new ArrayList[26];
        IntStream.range(0, pos.length).forEach(i -> pos[i] = new ArrayList<>());
        for (int i = 0; i < rings.length; i++) pos[rings[i] - 'a'].add(i);

        int[][] dp = new int[keys.length][rings.length];
        //填充
        for (int[] item : dp) Arrays.fill(item, ban);

        for (int i = 0; i < keys.length; i++) {
            for (int j : pos[keys[i] - 'a']) {
//                dp[i][j];  //来源于上一个的状态 dp[i-1][k]的状态,有点像神经网络
                if (i == 0) {
                    dp[i][j] = distance(rings.length, i, j) + 1;
                } else {
                    for (int k : pos[keys[i - 1] - 'a']) {
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + distance(rings.length, k, j) + 1);
                    }
                }
            }
        }

        int result = ban;
        for (int dis : dp[keys.length - 1]) result = Math.min(result, dis);
        return result;
    }

    private int distance(int len, int a, int b) {
        //现在在a点,要移动到b点,最短的距离
        int gap = Math.abs(a - b);
        return Math.min(gap, len - gap);
    }

    public static void main(String[] args) {
        String ring = "godding", key = "gd";
        Q514_freedom_trail s = new Q514_freedom_trail();
        int rotateSteps = s.findRotateSteps(ring, key);
        System.out.println(rotateSteps);
    }
}
