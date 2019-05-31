package 排序;

import java.util.Arrays;

public class QuickSort {
    public void qSort(int[] nums, int low, int high) {
        //颜色分类的思想,存储和扫遍2个指针.找到比pivot小的,就往++store指针上扔,
        if (high <= low) return;
        int pivot = nums[low];
        int store = low;
        for (int scan = low + 1; scan <= high; scan++) {
            if (nums[scan] < pivot) {
                swap(nums, ++store, scan);
            }
        }
        //最后此时store本身和左边都是小于等于pivot.原来的pivot在low位上,store为边界位置,交换一下即可.代码简单.不会越界
        swap(nums, low, store);
        qSort(nums, low, store - 1);
        qSort(nums, store + 1, high);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    public static void main(String[] args) {
        QuickSort s = new QuickSort();
        int[] nums = {1, 2, 3, 3, 3, 44, 3, 34, 3, 4, 32, 2, 4, 234, 23, 4, 23};
        s.qSort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
