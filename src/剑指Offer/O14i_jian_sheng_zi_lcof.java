package 剑指Offer;

public class O14i_jian_sheng_zi_lcof {
    public int cuttingRope(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            //对绳子进行二段分解
            for (int j = 1; j <= i / 2; j++) {
                int len1 = j;
                int len2 = i - j;
                dp[i] = Math.max(dp[i], Math.max(len1, dp[len1]) * Math.max(len2, dp[len2]));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        O14i_jian_sheng_zi_lcof o14i_jian_sheng_zi_lcof = new O14i_jian_sheng_zi_lcof();
        int i = o14i_jian_sheng_zi_lcof.cuttingRope(10);
        System.out.println(i);
    }
}
