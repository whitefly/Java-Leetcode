package 排列组合;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class Q31_next_permutation {

    private void reverse(int[] nums, int begin, int end) {
        int half = (end - begin + 1) / 2;
        for (int i = 0; i < half; i++) {
            swap(nums, begin + i, end - i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public void nextPermutation(int[] nums) {
        /**
         * 思入: 最大的情况是 最大的数占的最左边, 现在要找大一点点的数, 所以需要将右边一个较大的数,向他最终的位置移动一点点即可
         * 最终的位置是超越所有比他小的数,现在只需要左边一个比他小的数即可
         * 具体思想: 从左<-----右 找到第一个比他左大的数,然后找到交换位置, 然后右部分呈最小组合排列(升序)
         */
        int size = nums.length;
        int last = size - 2;
        //左<-----右找特定数
        while (last >= 0 && nums[last] >= nums[last + 1]) last--;
        //找不到,已经最大,反转变为最小
        if (last == -1) {
            reverse(nums, 0, size - 1);
            return;
        }
        //在右边找一个比它大点的数交换
        int greater = size - 1;
        while (nums[last] >= nums[greater]) greater--;
        swap(nums, last, greater);
        //右部分升序(反转即可)
        reverse(nums, last + 1, size - 1);
    }

    public void nextPermutation2(int[] nums) {
        //找左右的分离点
        if (nums.length <= 1) return;
        int split = nums.length - 1; //右边第一个
        for (; split >= 0; split--) {
            if (split == 0) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            if (nums[split - 1] < nums[split]) break;
        }
        //右边找到一个大数来替换
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[split-1] < nums[i]) {
                swap(nums, i, split - 1);
                break;
            }
        }
        reverse(nums, split, nums.length - 1);
    }


    public static void main(String[] args) {
        Q31_next_permutation s = new Q31_next_permutation();
        int nums[] = {1,1,5};
        s.nextPermutation2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
