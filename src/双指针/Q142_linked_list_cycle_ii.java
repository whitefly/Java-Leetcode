package 双指针;

public class Q142_linked_list_cycle_ii {
    public ListNode detectCycle(ListNode head) {
        /**
         *  思入: 快慢指针+长度的关系
         */
        ListNode fast = head, slow = head, slow2 = head;
        do {
            if (fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        } while (slow != fast);
        while (slow != slow2) {
            slow = slow.next;
            slow2 = slow2.next;
        }
        return slow;
    }
}
