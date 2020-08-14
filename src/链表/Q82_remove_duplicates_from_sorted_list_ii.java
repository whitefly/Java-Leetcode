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

    public ListNode deleteDuplicates2(ListNode head) {
        /**
         * 非递归写法
         */
        if (head == null || head.next == null) return head;
        ListNode result = new ListNode(-1);
        ListNode LL = result;
        LL.next = head;
        ListNode scan = head.next;
        ListNode next;
        int pre = head.val;

        while (scan != null) {
            next = scan.next;
            if (pre == scan.val) {
                LL.next = null;
            } else {
                if (LL.next == null) {
                    LL.next = scan;
                } else {
                    LL.next.next = scan;
                    LL = LL.next;
                }
            }
            pre = scan.val;
            scan.next = null;
            scan = next;
        }
        return result.next;
    }
}
