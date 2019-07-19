package 堆;

import java.util.Map;
import java.util.PriorityQueue;

public class Q703_kth_largest_element_in_a_stream {
    /*
    思入: 大数据算法中的topk问题,小根堆
     */
    static class KthLargest {
        PriorityQueue<Integer> heap;
        int k;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            heap = new PriorityQueue<>(k);
            for (int i = 0; i < nums.length; i++) heap.add(nums[i]);
            while (heap.size() > k) {
                heap.poll();
            }
        }

        public int add(int val) {
            if (heap.size() == k) {
                if (heap.peek() <= val) {
                    heap.poll();
                    heap.add(val);
                }
            } else {
                heap.add(val);
            }
            return heap.peek();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(kthLargest.add(3)); // returns 4
        System.out.println(kthLargest.add(5));// returns 5
        System.out.println(kthLargest.add(10));// returns 5
        System.out.println(kthLargest.add(9));// returns 8
        System.out.println(kthLargest.add(4));// returns 8
    }
}

