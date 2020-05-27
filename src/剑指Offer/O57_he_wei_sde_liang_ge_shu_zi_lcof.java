package 剑指Offer;

public class O57_he_wei_sde_liang_ge_shu_zi_lcof {
    public int[] twoSum(int[] nums, int target) {
        int L = 0, R = nums.length - 1, sum;
        while (L < R) {
            sum = nums[L] + nums[R];
            if (sum == target) return new int[]{nums[L], nums[R]};
            else if (sum > target) R--;
            else L++;
        }
        return nums;
    }
}
