package 剑指Offer;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class O60_nge_tou_zi_de_dian_shu_lcof {
    public double[] twoSum(int n) {
        //动态规划. dp[i][n]表示 执第i个色子的累计和为n的概率
        //状态转移: dp[i][n]= dp[i-1][n-1] + dp[i-1][n-2] + dp[i-1][n-3] +...dp[i-1][1]
        //第n可  n-6n

        double[][] dp = new double[n][6 * n + 1];
        for (int i = 1; i <= 6; i++) dp[0][i] = 1.0 / 6;
        for (int id = 1; id < n; id++) {
            //第n颗色子
            int limit = 6 * (id + 1);
            for (int cum = id+1; cum <= limit; cum++) {
                for (int k = 1; k <= 6; k++) {
                    if ((cum - k) >= 1) {
                        dp[id][cum] += dp[id - 1][cum - k] * 1.0 / 6;
                    }
                }
            }
        }
        return Arrays.copyOfRange(dp[n - 1], n, (6 * n) + 1);
    }

    public static void main(String[] args) {
        O60_nge_tou_zi_de_dian_shu_lcof s = new O60_nge_tou_zi_de_dian_shu_lcof();
        double[] doubles = s.twoSum(3);
        System.out.println(Arrays.toString(doubles));
    }
}
