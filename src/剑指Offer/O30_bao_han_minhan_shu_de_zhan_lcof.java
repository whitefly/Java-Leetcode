package 剑指Offer;

import java.util.LinkedList;
import java.util.Stack;

public class O30_bao_han_minhan_shu_de_zhan_lcof {

    static class Node {
        int val;
        int minVal;

        public Node(int val, int minVal) {
            this.val = val;
            this.minVal = minVal;
        }
    }

    static class MinStack {
        //空间换时间,由于站定下面的元素不变,所以最小的元素可以在加入时算出来.
        //stack存放节点: 2个属性 val 和 minVal

        /**
         * initialize your data structure here.
         */
        Stack<Node> stack;

        public MinStack() {
            stack = new Stack<>();
        }

        public void push(int x) {
            if (stack.isEmpty()) stack.add(new Node(x, x));
            else {
                stack.add(new Node(x, Math.min(stack.peek().minVal, x)));
            }
        }

        public void pop() {
            if (!stack.isEmpty()) {
                stack.pop();
            }
        }

        public int top() {
            return stack.peek().val;
        }

        public int min() {
            return stack.peek().minVal;
        }
    }
}
