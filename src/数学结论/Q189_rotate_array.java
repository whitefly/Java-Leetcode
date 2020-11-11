package 数学结论;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q189_rotate_array {
    public void rotate(int[] nums, int k) {
        /**
         * 思入: 王道考研的原题  AB  (A^T * B^T)^T= BA
         */

        k = nums.length - k % nums.length;

        //3次反转
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    private void reverse(int[] nums, int begin, int end) {
        if (begin > end) return;
        int half = (end - begin) / 2;
        for (int i = 0; i <= half; i++) {
            int temp = nums[begin + i];
            nums[begin + i] = nums[end - i];
            nums[end - i] = temp;
        }
    }

    public void rotate2(int[] nums, int k) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        Collections.rotate(list, k);
        IntStream.range(0, nums.length).forEach(i -> nums[i] = list.get(i));
    }

    public static void main(String[] args) {
        int[] nums = {1};
        int k = 0;
        Q189_rotate_array s = new Q189_rotate_array();
        s.rotate(nums, k);
        System.out.println(Arrays.toString(nums));
    }
}
