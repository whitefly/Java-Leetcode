package 剑指Offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class O59_dui_lie_de_zui_da_zhi_lcof {
    static class MaxQueue {
        private Queue<Integer> queue;  //用于正常的pop和push方法
        private Deque<Integer> deque;  //用于max()方法,单调队列

        public MaxQueue() {
            queue = new LinkedList<>();
            deque = new LinkedList<>();
        }

        public int max_value() {
            return deque.isEmpty() ? -1 : deque.getFirst();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!deque.isEmpty() && deque.getLast() < value) deque.pollLast();
            deque.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            Integer peek = queue.poll();
            if (deque.getFirst().equals(peek)) deque.pollFirst();
            return peek;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

    }
}
