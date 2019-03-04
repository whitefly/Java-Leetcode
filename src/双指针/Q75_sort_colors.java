package 双指针;

import java.util.Arrays;

public class Q75_sort_colors {
    public void sortColors(int[] nums) {
        /**
         * 思入: 使用双指针, 用L指针保存未来存放0的位置,R指针保存未来存储2的位置,只要保证0,2归位,1不用管
         * 实现:
         * 碰到[current]=0, 则交换L,L++,current++(因为current比L快,都会验证过,换过来一定是1,不需要在重复验证),开始下一轮
         * 碰到[current]=1,则忽略,current++,
         * 碰到[current]=2,则交换R,R--,开始下一轮
         */

        int L = 0, index = 0, R = nums.length - 1;
        while (index <= R) {
            int num = nums[index];
            if (num == 0) {
                swap(nums, L++, index++);
            } else if (num == 1) index++;
            else swap(nums, R--, index);
        }
    }

    public void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }

    public static void main(String[] args) {
        Q75_sort_colors s = new Q75_sort_colors();
        int[] nums = {1, 1, 1, 1, 2, 1, 1, 1, 0, 0, 0, 0, 2, 1, 1, 1, 1, 1, 0, 2, 1, 1, 1, 2, 1, 0, 2, 2, 1, 1, 1, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
