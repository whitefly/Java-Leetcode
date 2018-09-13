package 哈希;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Q1_two_sum {
    public int[] twoSum(int[] nums, int target) {
        /**
         * 思入: hash思想扫一遍
         *
         */
        Map<Integer, Integer> buf = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (buf.containsKey(nums[i])) {
                return new int[]{buf.get(nums[i]), i};
            }
            buf.put(target - nums[i], i);
        }
        throw new IllegalArgumentException("no result");
    }


    public int[] twoSum2(int[] nums, int target) {
        /**
         * 思入: 排序+双指针(搞不了下标)
         */
        Arrays.sort(nums);
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int sum = nums[l] + nums[r];
            if (sum == target) {
                return new int[]{l, r};
            } else if (sum < target) {
                l++;
            } else {
                r--;
            }
        }
        throw new IllegalArgumentException("no result");
    }


    public static void main(String args[]) {
        int my_nums[] = {3, 2, 4}, target = 6;

        Q1_two_sum s = new Q1_two_sum();
        int hehe[] = s.twoSum2(my_nums, target);
        System.out.println(Arrays.toString(hehe));
    }
}
