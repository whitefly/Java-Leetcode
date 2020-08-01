package 子数组;

public class Q795_number_of_subarrays_with_bounded_maximum {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        //思入:dp+推理
        //dp[i]表示以nums[i]结尾的子数组,且符合条件的个数
        // 推理状态转义方程: 如果 nums[i]<L,dp[i]=dp[i-1] 如果 nums[i]>R,dp[i]=0, 如果 nums[i]中间,dp[i]=i-preBig ,preBig为上一个大于R的数
        //所以需要维护一个 preBig变量
        int preBig = -1;
        int dp = 0;
        int count = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > R) {
                preBig = i;
                dp = 0;
            } else if (A[i] < L) {
                dp = dp;
            } else {
                dp = i - preBig;
            }
            count += dp;
        }
        return count;
    }
}
