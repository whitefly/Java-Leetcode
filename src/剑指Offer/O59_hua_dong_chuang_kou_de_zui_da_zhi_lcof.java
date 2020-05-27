package 剑指Offer;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class O59_hua_dong_chuang_kou_de_zui_da_zhi_lcof {

    static class MonotonousQueue {
        Deque<Integer> queue = new LinkedList<>();

        public void add(int val) {
            while (!queue.isEmpty() && queue.getLast() < val) queue.pollLast();
            queue.add(val);
        }

        public void poll() {
            if (!queue.isEmpty()) {
                queue.poll();
            }
        }

        public int max() {
            return queue.getFirst();
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return nums;
        MonotonousQueue queue = new MonotonousQueue();
        int[] result = new int[nums.length - k + 1];
        int L, R, index = -1;
        for (L = 0, R = 0; R < nums.length; R++) {
            if (R < (k - 1)) {
                //不满k个
                queue.add(nums[R]);
            } else if (R == (k - 1)) {
                // 第一次达到k个
                queue.add(nums[R]);
                result[++index] = queue.max();
            } else {
                // 固定k滑动状态
                queue.add(nums[R]);
                if (queue.max() == nums[L]) queue.poll();
                L++;
                result[++index] = queue.max();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        O59_hua_dong_chuang_kou_de_zui_da_zhi_lcof s = new O59_hua_dong_chuang_kou_de_zui_da_zhi_lcof();
        int[] ints = s.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ints));
    }
}
