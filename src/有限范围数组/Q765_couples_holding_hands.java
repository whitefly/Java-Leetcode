package 有限范围数组;

import java.util.Arrays;

public class Q765_couples_holding_hands {
    public int minSwapsCouples(int[] row) {
        /**
         * 思入:  每次定住pair的左边,在rest部分找右边,找到后交换位置. (若左边已经是了,不用在寻找了)
         * 问题: 为什么这种交换策略可以达到最小交换次数,即证明这种贪心策略成立?
         */
        int swap_count = 0;
        for (int i = 0; i < row.length; i += 2) {
            int num1 = row[i];
            int find_num = (num1 % 2 == 0) ? num1 + 1 : num1 - 1;
            if (row[i + 1] != find_num) {
                //寻找并交换
                int j = i + 2;
                while (j < row.length && row[j] != find_num) j++;
                swap(row, i + 1, j);
                swap_count++;
            }
        }
        return swap_count;
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 2, 1, 3};
        Q765_couples_holding_hands s = new Q765_couples_holding_hands();
        int i = s.minSwapsCouples(nums);
        System.out.println(i);

    }
}

