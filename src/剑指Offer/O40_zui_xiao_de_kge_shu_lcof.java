package 剑指Offer;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class O40_zui_xiao_de_kge_shu_lcof {
    public int[] getLeastNumbers(int[] arr, int k) {
        //topK文件,在一群小的中间找最大的进行比较
        int[] result = new int[k];
        if (k == 0) return result;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int i = 0; i < arr.length; i++) {
            if (heap.size() < k) heap.add(arr[i]);
            else {
                if (heap.peek() > arr[i]) {
                    heap.poll();
                    heap.add(arr[i]);
                }
            }
        }
        return heap.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,3,5};
        int k = 2;
        O40_zui_xiao_de_kge_shu_lcof s = new O40_zui_xiao_de_kge_shu_lcof();
        int[] leastNumbers = s.getLeastNumbers(arr, k);
        System.out.println(Arrays.toString(leastNumbers));
    }
}
