package 重复元素;

import java.util.Arrays;

public class Q26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        /**
         *思想:2个指针,1个指针指向存储位置的上一个位置,1个指向指向遍历位置
         */
        int size = nums.length;
        if (size == 0 || size == 1) return size;
        int index1 = 0;
        for (int index2 = 1; index2 < nums.length; index2++) {
            if (nums[index1] == nums[index2]) continue;
            else nums[++index1] = nums[index2];
        }
        return index1 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        Q26_remove_duplicates_from_sorted_array s = new Q26_remove_duplicates_from_sorted_array();
        int i = s.removeDuplicates(nums);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));

    }
}
