package 双指针;

public class Q141_linked_list_cycle {
    public boolean hasCycle(ListNode head) {
        /**
         * 思入: 快慢指针的思想
         */
        ListNode slow = head, fast = head;
        do {
            if (fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        } while (slow != fast);
        return true;
    }

}
