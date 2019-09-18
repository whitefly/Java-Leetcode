package 堆;

import java.util.*;

public class Q347_top_k_frequent_elements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        /*
        思入:  统计完频率后,转化为TopK问题,使用堆解决
         */
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int num : nums) counter.compute(num, (key, v) -> v == null ? 1 : v + 1);

        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.comparingInt(counter::get)); //小根堆
        counter.forEach((key, v) -> {
            if (heap.size() >= k) {
                if (counter.get(heap.peek()) < counter.get(key)) {
                    heap.poll();
                    heap.add(key);
                }
            } else {
                heap.add(key);
            }
        });
        return new ArrayList<>(heap);
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        Q347_top_k_frequent_elements s = new Q347_top_k_frequent_elements();
        System.out.println(s.topKFrequent(nums, k));
    }
}
