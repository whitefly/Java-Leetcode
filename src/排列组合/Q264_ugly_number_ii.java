package 排列组合;

import java.util.*;

public class Q264_ugly_number_ii {


    public long nthUglyNumber(int n) {
        int[] nums = {2, 3, 5};
        Set<Long> set = new HashSet<>();
        int size = n * 5;
        int id = 0;
        Queue<Long> Q = new LinkedList<>();
        PriorityQueue<Long> heap = new PriorityQueue<>();
        Q.offer(1L);
        while (!Q.isEmpty()) {
            long temp = Q.poll();
            heap.add(temp);
            id++;
            if (id == size) break;
            for (int num : nums) {
                long one = num * temp;
                if (!set.contains(one)) {
                    set.add(one);
                    Q.offer(one);
                }
            }
        }
        long result = -1;
        for (int i = 0; i < n; i++) {
            result = heap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        Q264_ugly_number_ii s = new Q264_ugly_number_ii();
        long i = s.nthUglyNumber(1000);

        System.out.println(i);
    }
}
