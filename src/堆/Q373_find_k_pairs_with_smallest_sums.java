package 堆;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Q373_find_k_pairs_with_smallest_sums {
    class Pair implements Comparable<Pair> {
        int a;
        int b;
        int sum;

        private Pair(int a, int b) {
            this.a = a;
            this.b = b;
            this.sum = a + b;
        }


        @Override
        public int compareTo(Pair o) {
            return this.sum - o.sum;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        /**
         * 思入: 暴力扫遍所有组合m*n种,然后存入堆.然后取出前k个即可
         */
        List<int[]> result = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0) return result;
        PriorityQueue<Pair> heap = new PriorityQueue<>();
        for (int n1 : nums1) {
            for (int n2 : nums2) {
                heap.add(new Pair(n1, n2));
            }
        }
        //取出前k个
        int size = Math.min(k, heap.size());
        for (int i = 0; i < size; i++) {
            Pair pair = heap.poll();
            result.add(new int[]{pair.a, pair.b});
        }
        return result;
    }

    public static void main(String[] args) {
        Q373_find_k_pairs_with_smallest_sums s = new Q373_find_k_pairs_with_smallest_sums();
        int[] num1 = {1, 1, 2};
        int[] num2 = {1, 2, 3};
        int k = 2;
        List<int[]> ints = s.kSmallestPairs(num1, num2, k);
        for (int[] p : ints) {
            System.out.println(Arrays.toString(p));
        }
    }
}
