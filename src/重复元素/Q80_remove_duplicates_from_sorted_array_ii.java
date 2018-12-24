package 重复元素;

import java.util.Arrays;

public class Q80_remove_duplicates_from_sorted_array_ii {
    public int removeDuplicates(int[] nums) {
        /**
         *思想: 双指针: 一个指针指向要存储位置的上一个, 一个指针指向遍历元素, 设置一个count位表示index1元素已经出现的个数.
         */
        int size = nums.length;
        if (size == 0 || size == 1) return size;
        int count = 1, index1 = 0;
        for (int index2 = 1; index2 < size; index2++) {
            int num1 = nums[index1], num2 = nums[index2];
            if (num1 != num2) {
                nums[++index1] = nums[index2];
                count = 1;
            } else if (count != 2) {
                nums[++index1] = nums[index2];
                count++;
            }
        }
        return index1 + 1;
    }

    public static void main(String[] args) {
        Q80_remove_duplicates_from_sorted_array_ii s = new Q80_remove_duplicates_from_sorted_array_ii();
        int[] nums = {1, 2};
        s.removeDuplicates(nums);
        System.out.println(Arrays.toString(nums));
    }
}
