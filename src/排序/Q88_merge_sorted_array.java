package 排序;

import java.util.Arrays;

public class Q88_merge_sorted_array {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        /**
         * 思入: 和链表一样,需要2个指针.但是num2的数字插入时,会导致指针移位.所以从左->右的思入被否,只能从右->左(即先选择大)
         * 同样需要3个指针
         */
        int index1 = m - 1, index2 = n - 1, index3 = m + n - 1;
        while (index2 >= 0) {
            int num1 = (index1 >= 0) ? nums1[index1] : Integer.MIN_VALUE;
            int num2 = nums2[index2];
            if (num1 <= num2) {
                nums1[index3--] = num2;
                index2--;
            } else {
                nums1[index3--] = num1;
                index1--;
            }
        }
    }

    public static void main(String[] args) {
        int[] buf1 = {0};
        int[] buf2 = {1};
        int m = 0, n = 1;
        Q88_merge_sorted_array s = new Q88_merge_sorted_array();
        s.merge(buf1, m, buf2, n);
        System.out.println(Arrays.toString(buf1));

    }
}
