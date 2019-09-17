package 滑动窗口;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Q239_sliding_window_maximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        /*
        思入: 滑动窗口+堆. 貌似和TopK写法差不多
         */
        if (nums.length == 0) return new int[0];
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> nums[o2] - nums[o1]);
        for (int i = 0; i < k; i++) {
            heap.add(i);
        }
        result[0] = nums[heap.peek()];
        for (int i = k, j = 1; i < nums.length; i++, j++) {
            heap.add(i);
            heap.remove(i - k);
            result[j] = nums[heap.peek()];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        Q239_sliding_window_maximum s = new Q239_sliding_window_maximum();
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, 3)));
    }
}
