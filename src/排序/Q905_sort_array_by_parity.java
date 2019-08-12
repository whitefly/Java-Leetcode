package 排序;

import java.util.Arrays;

public class Q905_sort_array_by_parity {
    /*
    思入: 快排思想进行原地分离.
     存储+扫描指针, 判定第一个是否需要交换
     */
    public int[] sortArrayByParity(int[] A) {
        if (A.length == 0) return A;
        int store = 0;
        for (int scan = store + 1; scan < A.length; scan++) {
            if ((A[scan] & 1) == 0) swap(A, ++store, scan);
        }
        if ((A[0] & 1) == 1) swap(A, 0, store);
        return A;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 2, 4};
        Q905_sort_array_by_parity s = new Q905_sort_array_by_parity();
        s.sortArrayByParity(nums);
        System.out.println(Arrays.toString(nums));
    }
}
