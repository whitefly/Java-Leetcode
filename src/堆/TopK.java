package 堆;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class TopK {
    public int find_kth(int[] nums, int k) {
        /**
         * 思入:使用容量为k的堆来完成topK问题.
         * 时间复杂度: 需要扫一遍,在最坏的情况下(每次都需要替换顶部+下移,每次操作一次需要logk),总共O(N*logK)
         * 空间复杂度: O(K)
         */
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        if (k <= 0 || nums.length < k) {
            throw new IllegalArgumentException("nums size is greater than k");
        }

        //创建一个大小为k为堆(将[0,k)个元素加入堆)
        for (int i = 0; i < k; i++) {
            heap.add(nums[i]);
        }
        //开始选择性加入.(由于没有替换操作,只能采用先移除,后加入的方式.相当于多调整了一次)
        for (int i = k; i < nums.length; i++) {
            int num = nums[i];
            if (num < heap.peek()) continue;
            heap.poll();
            heap.add(num);
        }
        return heap.peek();
    }

    public int find_kth2(int[] nums, int k) {
        return helper(nums, 0, nums.length - 1, k);
    }

    public int helper(int[] nums, int low, int high, int k) {
        /**
         * 思入: 基于快速排序的思想. 每扫过一轮.就可以将一个数字放在正确的位置上.若这个位置比k大,则只需要管左边的.若比k小,则只需要管右边的.若恰好等于k,则返回这个k
         */
        int index = partion(nums, low, high);
        if (index == (k - 1)) return nums[index];
        if (index < (k - 1)) return helper(nums, index + 1, high, k);
        return helper(nums, low, index - 1, k);
    }


    public int partion(int[] nums, int low, int high) {
        //颜色分类的思想,存储和扫遍2个指针.找到比pivot小的,就往++store指针上扔,
        if (high <= low) return low;
        int pivot = nums[low];
        int store = low;
        for (int scan = low + 1; scan <= high; scan++) {
            if (nums[scan] < pivot) {
                swap(nums, ++store, scan);
            }
        }
        //最后此时store本身和左边都是小于等于pivot.原来的pivot在low位上,store为边界位置,交换一下即可.代码简单.不会越界
        swap(nums, low, store);
        return store;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 7, 8, 4, 1, 2, 6, 9, 5};
        int k = 5;
        TopK s = new TopK();
        int kth = s.find_kth2(nums, k);
        System.out.println(kth);
    }
}
