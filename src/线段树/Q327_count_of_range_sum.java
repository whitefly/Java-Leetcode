package 线段树;

public class Q327_count_of_range_sum {
    public int countRangeSum(int[] nums, int lower, int upper) {
    /*
    思入: 暴力法. 遍历所有组合 dp[i]表示从[0,i]的总. 则 sum(i,j)= dp[j]-dp[i-1]
     */
        if (nums.length == 0) return 0;
        long[] dp = new long[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) dp[i] = dp[i - 1] + nums[i];
        int result = 0;
        long temp;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                temp = dp[j] - (i == 0 ? 0 : dp[i - 1]);
                if (lower <= temp && temp <= upper) result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};
        int left = -564;
        int right = 2864;
        Q327_count_of_range_sum s = new Q327_count_of_range_sum();
        System.out.println(s.countRangeSum(nums, left, right));
    }
}
