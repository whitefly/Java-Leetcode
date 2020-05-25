package 剑指Offer;

import java.util.PriorityQueue;

public class O41_shu_ju_liu_zhong_de_zhong_wei_shu_lcof {
    /**
     * initialize your data structure here.
     */
    PriorityQueue<Integer> minHeap;  //放较大的数
    PriorityQueue<Integer> maxHeap;  //放较小的数
    int index;

    public O41_shu_ju_liu_zhong_de_zhong_wei_shu_lcof() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        index = 0;
    }

    public void addNum(int num) {
        index++;
        //奇数index就经过 minHeap 中转最后到 maxHeap;
        if ((index & 1) == 1) {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        } else {
            //偶数index就经过maxHeap 中转最后到 minHeap;
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
    }

    public double findMedian() {
        //含有奇数时,max多一个
        if ((index & 1) == 1) return maxHeap.peek();
        else return ((double) minHeap.peek() + maxHeap.peek()) / 2;
    }

    public static void main(String[] args) {
        O41_shu_ju_liu_zhong_de_zhong_wei_shu_lcof s = new O41_shu_ju_liu_zhong_de_zhong_wei_shu_lcof();
        s.addNum(1);
        s.addNum(2);
        System.out.println(s.findMedian());
        s.addNum(3);
        System.out.println(s.findMedian());
    }
}
