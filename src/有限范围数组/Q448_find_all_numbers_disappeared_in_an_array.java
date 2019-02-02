package 有限范围数组;

import java.util.ArrayList;
import java.util.List;

public class Q448_find_all_numbers_disappeared_in_an_array {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        /**
         * 思入: 索引设置负数法. 若已经为负数,说明之前出现过,所以不用在管了, 遍历完后在扫一遍. 找到索引为正的位置,返回索引
         */
        List<Integer> result = new ArrayList<>();
        for (int num : nums) {
            int index = Math.abs(num) - 1;
            if (nums[index] > 0) nums[index] = -nums[index];
        }
        //找到正数的索引
        for (int i = 0; i < nums.length; i++) if (nums[i] > 0) result.add(i + 1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        Q448_find_all_numbers_disappeared_in_an_array s = new Q448_find_all_numbers_disappeared_in_an_array();
        List<Integer> r = s.findDisappearedNumbers(nums);
        System.out.println(r);
    }
}
