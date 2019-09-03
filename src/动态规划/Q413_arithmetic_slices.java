package 动态规划;

public class Q413_arithmetic_slices {
    public int numberOfArithmeticSlices(int[] A) {
            /*
            思入: 动态规划+ 后缀相加 (类似最长连续子串那题)
            dp[i]表示以位置元素结尾的最长等差串长度.
            可以将空间复优化为O(1)
             */
        if (A.length < 3) return 0;
        int[] dp = new int[A.length];
        int result = 0;
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < A.length; i++) {
            dp[i] = (A[i - 1] - A[i - 2] == A[i] - A[i - 1]) ? dp[i - 1] + 1 : 2;

            if (dp[i] >= 3) result += dp[i] - 2;
        }
        return result;
    }
}
