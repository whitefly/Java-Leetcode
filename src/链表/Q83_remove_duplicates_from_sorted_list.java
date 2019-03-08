package 链表;

public class Q83_remove_duplicates_from_sorted_list {
    ListNode last = null;

    public ListNode deleteDuplicates(ListNode head) {
        /**
         * 递归拼接树
         */
        if (head == null) return null;
        if (last == null || last.val != head.val) {
            last = head;
            head.next = deleteDuplicates(head.next);
            return head;
        } else return deleteDuplicates(head.next);
    }
}
