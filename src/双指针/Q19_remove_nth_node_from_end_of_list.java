package 双指针;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q19_remove_nth_node_from_end_of_list {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        /**
         * 思入:滑动窗口的思想
         */
        ListNode index1 = head, index2 = head;
        for (int i = 0; i < n; i++) index2 = index2.next;
        if (index2 == null) return head.next;
        //同时移动
        while (index2.next != null) {
            index1 = index1.next;
            index2 = index2.next;
        }
        //删除节点,index1是要删除节点的上一个节点
        index1.next = index1.next.next;
        return head;

    }
}
