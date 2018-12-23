package 链表;

public class Q24_swap_nodes_in_pairs {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode swapPairs(ListNode head) {
        /**
         * 尝试用递归写,将链表分段,现在的1对+剩下的.
         * 将给定的链表排好序,拼接好,然后返回
         */
        if (head == null) return null;
        if (head.next == null) return head;

        ListNode node1 = head;
        ListNode node2 = head.next;
        ListNode rest = head.next.next;

        //倒转
        node2.next = node1;
        node1.next = swapPairs(rest);
        return node2;

    }
}
