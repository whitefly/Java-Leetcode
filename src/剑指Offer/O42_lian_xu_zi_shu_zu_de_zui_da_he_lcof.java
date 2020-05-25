package 剑指Offer;

public class O42_lian_xu_zi_shu_zu_de_zui_da_he_lcof {
    public static int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        //dp[i] 表示以nums[i]为尾的子数组最大和
        int dp = -1;
        for (int i = 0; i < nums.length; i++) {
            dp = (dp < 0) ? nums[i] : dp + nums[i];
            result = Math.max(dp, result);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1};
        System.out.println(maxSubArray(nums));

    }
}
