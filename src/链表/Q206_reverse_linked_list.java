package 链表;


public class Q206_reverse_linked_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        /**
         * 思入:额外准备一个指针来记录last节点
         */

        ListNode last = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = last;
            last = head;

            head = next;
        }
        return last;
    }
}
