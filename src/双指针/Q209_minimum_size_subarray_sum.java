package 双指针;

public class Q209_minimum_size_subarray_sum {
    public int minSubArrayLen(int s, int[] nums) {
        /**
         *  思入: 滑动窗口的思想 小了就右指针右移动,大了就左指针右移. 每次都记录符合条件的最长的长度
         */

        int l = 0, r = 0, size = nums.length;
        if (size == 0) return 0;

        int sum = nums[0];
        int result = Integer.MAX_VALUE;
        while (l <= r && r < size) {
            if (sum >= s) result = Math.min(result, r - l + 1); //本轮的结果 由上一轮最后产生.

            if (sum < s) {
                if (++r >= size) break;
                sum += nums[r];
            } else sum -= nums[l++];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }


    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        Q209_minimum_size_subarray_sum s = new Q209_minimum_size_subarray_sum();
        int i = s.minSubArrayLen(7, nums);
        System.out.println(i);
    }
}
