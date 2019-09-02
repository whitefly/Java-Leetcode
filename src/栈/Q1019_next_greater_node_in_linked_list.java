package 栈;

import java.util.Stack;

public class Q1019_next_greater_node_in_linked_list {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] nextLargerNodes(ListNode head) {
            /*
            思入:  右起做第一个比它大..  使用递减栈, 可以确定弹出元素的右大
             */
        ListNode node = head;
        int size = 0;
        while (node != null) {
            size++;
            node = node.next;
        }

        int[] result = new int[size];
        int index = 0;
        Stack<int[]> stack = new Stack<>();
        while (head != null) {
            int temp = head.val;
            while (!stack.isEmpty() && stack.peek()[1] < temp) result[stack.pop()[0]] = temp;

            stack.add(new int[]{index++, temp});
            head = head.next;
        }

        while (!stack.isEmpty()) result[stack.pop()[0]] = 0;
        return result;
    }
}
