package 有限范围数组;

import java.util.Arrays;

public class Q268_missing_number {
    public int missingNumber(int[] nums) {
        /**
         *思入:  全部数之和是定值, 全部数和-已有的数和就是缺失数字
         */
        int n = nums.length + 1;
        long total = (n - 1) * n / 2;
        for (int num : nums) total -= num;
        return (int) total;
    }

    public static void main(String[] args) {
        Q268_missing_number s = new Q268_missing_number();
        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int i = s.missingNumber(nums);
        System.out.println(i);
    }


}
