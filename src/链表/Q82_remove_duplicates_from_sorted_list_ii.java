package 链表;


public class Q82_remove_duplicates_from_sorted_list_ii {
    ListNode last = null;

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 思入: 保留上一个被确定唯一的指针. 一旦碰到不重复的.进行唯一last指针交接
         */
        if (head == null) return null;
        if (last != null && last.val == head.val) return deleteDuplicates(head.next);
        last = head;
        if (head.next == null || head.next.val != head.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else return deleteDuplicates(head.next);

    }
}
