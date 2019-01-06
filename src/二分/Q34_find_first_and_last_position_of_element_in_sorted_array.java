package 二分;

import java.util.Arrays;

public class Q34_find_first_and_last_position_of_element_in_sorted_array {
    public int[] searchRange(int[] nums, int target) {
        /**
         * 思入: 2次二分,一次找首次出现的,一次找末次出现的
         */
        int[] result = {-1, -1};
        if (nums.length == 0) return result;
        int l = 0, r = nums.length - 1;
        //首次出现
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) r = mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if (target == nums[l]) result[0] = l;  //最后剩下1个
        else return result;

        //尾次出现(为了防止无限循环,只剩下2个时就跳出)
        l = 0;
        r = nums.length - 1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) l = mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if (target == nums[r]) result[1] = r;
        else if (target == nums[l]) result[1] = l;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5};
        int target = 5;
        Q34_find_first_and_last_position_of_element_in_sorted_array s = new Q34_find_first_and_last_position_of_element_in_sorted_array();
        int[] ints = s.searchRange(nums, target);
        System.out.println(Arrays.toString(ints));
    }
}
