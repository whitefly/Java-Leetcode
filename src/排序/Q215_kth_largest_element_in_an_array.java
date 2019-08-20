package 排序;

import java.util.Arrays;

public class Q215_kth_largest_element_in_an_array {
    /*
    思入: 快排的思想
     */
    private int k;

    public int findKthLargest(int[] nums, int k) {
        this.k = nums.length - k;
        return helper(nums, 0, nums.length - 1);
    }

    public int helper(int[] nums, int L, int R) {
        if (L == R) return nums[L];
        int pivot = nums[L];
        int store = L;
        for (int i = L + 1; i <= R; i++) {
            if (nums[i] < pivot) swap(nums, i, ++store);
        }
        swap(nums, L, store);
        if (store == k) return pivot;
        return store < k ? helper(nums, store + 1, R) : helper(nums, L, store - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        Q215_kth_largest_element_in_an_array s = new Q215_kth_largest_element_in_an_array();
        System.out.println(s.findKthLargest(nums, k));
    }
}
