package 链表;

public class Q203_remove_linked_list_elements {
    public ListNode removeElements(ListNode head, int val) {
        /**
         * 思入: 保留上个指针,来做好拼接,决定用递归写法, 本节点和剩余部分
         */
        if (head == null) return null;
        if (head.val == val) return removeElements(head.next, val);
        else {
            head.next = removeElements(head.next, val);
            return head;
        }
    }
}
