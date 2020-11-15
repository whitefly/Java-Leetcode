package 双指针;

import java.util.Arrays;

public class Q922_sort_array_by_parity_ii {
    /*
    思入: 双指针,一个在奇数index,一个在偶数index
     */
    public int[] sortArrayByParityII(int[] A) {
        int oddIndex = 1, evenIndex = 0;
        while (oddIndex < A.length && evenIndex < A.length) {
            while (oddIndex < A.length && (A[oddIndex] & 1) == 1) oddIndex += 2;
            if (oddIndex >= A.length) break;
            while (evenIndex < A.length && (A[evenIndex] & 1) == 0) evenIndex += 2;
            swap(A, oddIndex, evenIndex);
            oddIndex += 2;
            evenIndex += 2;
        }
        return A;
    }

    public int[] sortArrayByParityII2(int[] A) {
        //只需要扫偶数位,把不合适的交换一下集合
        int odd = 1;
        for (int i = 0; i < A.length; i += 2) {
            while ((A[i] & 1) == 1) {
                swap(A, i, odd);
                odd += 2;
            }
        }
        return A;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {4, 2, 5, 7};
        Q922_sort_array_by_parity_ii s = new Q922_sort_array_by_parity_ii();
        s.sortArrayByParityII2(nums);
        System.out.println(Arrays.toString(nums));
    }
}
