package 背包问题;

import java.util.Arrays;
import java.util.Comparator;

public class Q474_ones_and_zeroes {
    public int findMaxForm(String[] strs, int m, int n) {
        /*
         思入:
         01背包:  dp[i][v1][v2] 前i个物品参与决策,允许使用v1个0,v2个1,所获得最大价值
         有2种重量
         可以空间优化为 dp[v1][v2]
         */
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int[] count = count(strs[i]);
            for (int v1 = m; v1 >= count[0]; v1--) {
                for (int v2 = n; v2 >= count[1]; v2--) {
                    dp[v1][v2] = Math.max(dp[v1][v2], dp[v1 - count[0]][v2 - count[1]] + 1);
                }
            }
        }
        return dp[m][n];
    }

    private int[] count(String num) {
        int count = 0, index = 0;
        while (true) {
            index = num.indexOf('0', index) + 1;
            if (index == 0) break;
            count++;
        }
        return new int[]{count, num.length() - count};
    }


    public static void main(String[] args) {
//        String[] Array = {"10", "0001", "111001", "1", "0"};
//        int m = 5, n = 3;

        String[] Array = {"111", "1000", "1000", "1000"};
        int m = 9, n = 3;
        Q474_ones_and_zeroes s = new Q474_ones_and_zeroes();
        System.out.println(s.findMaxForm(Array, m, n));
    }

}
