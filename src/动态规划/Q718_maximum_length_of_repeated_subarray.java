package 动态规划;

public class Q718_maximum_length_of_repeated_subarray {
    public int findLength(int[] A, int[] B) {
        /*
        思入: 二维动态规划 dp[i][j]表示 数组1中i位置结尾和 数组2中j位置结尾的最大连续长度
        状态转移方程:  dp[i][j]=  (num[i]==nums[j])?dp[i-1][j-1]+1:0
        可以空间优化
         */
        int result = 0;
        int[] dp = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = B.length - 1; j >= 0; j--) {
                boolean flag = A[i] == B[j];
                if (i == 0 || j == 0) dp[j] = flag ? 1 : 0;
                else dp[j] = flag ? dp[j - 1] + 1 : 0;

                result = Math.max(result, dp[j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 2, 1};
        int[] B = {3, 2, 1, 4, 7};
        Q718_maximum_length_of_repeated_subarray s = new Q718_maximum_length_of_repeated_subarray();
        System.out.println(s.findLength(A, B));
    }
}
