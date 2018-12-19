package 双指针;

import java.util.Arrays;

public class Q16_3sum_closest {
    public int threeSumClosest(int[] nums, int target) {
        /**
         * 思入: 排序,定住一个,双指针遍历2个. 用一个min_gap来取最接近的差距
         */
        int min_gap = Integer.MAX_VALUE, size = nums.length;
        Arrays.sort(nums);
        for (int i = 0; i < size; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) continue;
            int l = i + 1, r = size - 1, x1 = nums[i];
            while (l < r) {
                int gap = target - (x1 + nums[l] + nums[r]);
                if (gap == 0) return target;
                min_gap = Math.abs(gap) < Math.abs(min_gap) ? gap : min_gap;
                if (gap > 0) {
                    l++;
                    while (l < r && nums[l - 1] == nums[l]) l++;
                } else {
                    r--;
                    while (l < r && nums[r] == nums[r + 1]) r--;
                }
            }
        }
        return target - min_gap;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int tagrget = 1;
        Q16_3sum_closest s = new Q16_3sum_closest();
        int i = s.threeSumClosest(nums, tagrget);
        System.out.println(i);

    }
}
