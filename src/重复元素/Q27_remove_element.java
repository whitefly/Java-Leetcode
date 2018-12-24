package 重复元素;

import java.util.Arrays;

public class Q27_remove_element {
    public int removeElement(int[] nums, int val) {
        /**
         * 思想:双指针,一个指针指向将要存储的位置,一个指针执行那个遍历的元素,一旦出现val,就跳过,否则就存储到对应位置
         */
        int index1 = 0;
        for (int index2 = 0; index2 < nums.length; index2++) {
            if (nums[index2] != val) nums[index1++] = nums[index2];
        }
        return index1;
    }

    public static void main(String[] args) {
        Q27_remove_element s = new Q27_remove_element();
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int i = s.removeElement(nums, val);
        System.out.println(i);
        System.out.println(Arrays.toString(nums));
    }
}
