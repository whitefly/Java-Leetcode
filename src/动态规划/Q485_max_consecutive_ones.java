package 动态规划;

public class Q485_max_consecutive_ones {
    public int findMaxConsecutiveOnes(int[] nums) {
        /*
        思入: 动态规划
        状态量: dp[i] 表示 以i元素为尾部,最长连续1的个数
         */
        int dp = 0, result = 0;
        for (int num : nums) {
            dp = (num == 1) ? dp + 1 : 0;
            result = Math.max(result, dp);
        }
        return result;
    }
}
