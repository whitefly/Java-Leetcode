package 链表;

public class Q25_reverse_nodes_in_k_group {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        /**
         * 递归写法: 相当于Q24题的变种,将2变为了k,本质没有变化,还是前k个为一组,剩下进位一组,然后递归
         */
        if (head == null) return null;
        //index为前一个部分的最后一个
        ListNode index = head;
        //将链表分为前k个部分和rest
        for (int i = 0; i < k - 1; i++) {
            if (index.next == null) return head;
            index = index.next;
        }
        ListNode rest = index.next;
        index.next = null;

        ListNode new_root = reverse_list(head);
        head.next = reverseKGroup(rest, k);
        return new_root;
    }

    private ListNode reverse_list(ListNode head) {
        //反转整个列表
        ListNode last = null, index = head;
        while (index != null) {
            ListNode next = index.next;
            index.next = last;
            last = index;
            index = next;
        }
        return last;
    }
}
