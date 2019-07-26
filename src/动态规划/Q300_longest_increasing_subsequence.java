package 动态规划;

public class Q300_longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        /*
         思入:一维序列动态规则的入门题型
         dp[i]状态: 以num[i]为结尾的最长上升子序列
         转移方程:  dp[i]=  max(dp[j])+1,其中j属于[0,j-1],且 num[j]<num[j])
         */
        int[] dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            int temp_max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) temp_max = Math.max(temp_max, dp[j]);
            }
            dp[i] = temp_max + 1;
            result = Math.max(dp[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Q300_longest_increasing_subsequence s = new Q300_longest_increasing_subsequence();
        System.out.println(s.lengthOfLIS(nums));
    }
}
