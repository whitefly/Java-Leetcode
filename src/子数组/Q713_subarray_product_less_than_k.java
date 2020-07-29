package 子数组;

public class Q713_subarray_product_less_than_k {
    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        //dp+推理+滑动窗口
        //dp[i]表示以num[i]结尾满足条件的个数,那么最小的窗口中,就有多个组合满足它
        int dp = 0, result = 0, product = 1;
        for (int L = 0, R = 0; R < nums.length; R++) {
            product *= nums[R];
            //回缩
            while (L < R && k <= product) {
                product /= nums[L++];
            }
            if (product < k) {
                result += R - L + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {10, 5, 2, 6};
        int i = numSubarrayProductLessThanK(nums, 100);
        System.out.println(i);
    }
}
