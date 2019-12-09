package 动态规划;

public class Q565_array_nesting {
    int[] dp;

    public int arrayNesting(int[] nums) {
        /*
        思入:  无方向的动态规划
         */
        dp = new int[nums.length];
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, helper(nums, i, i, 1));
        }
        return result;
    }

    private int helper(int[] nums, int index, int begin, int n) {
        if (dp[index] != 0) return dp[index];
        return dp[index] = (nums[index] == begin) ? n : helper(nums, nums[index], begin, n + 1);
    }

    public static void main(String[] args) {
        int[] A = {5, 4, 0, 3, 1, 6, 2};
        Q565_array_nesting s = new Q565_array_nesting();
        System.out.println(s.arrayNesting(A));
    }
}
