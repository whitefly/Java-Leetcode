package 剑指Offer;


public class O18_shan_chu_lian_biao_de_jie_dian_lcof {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) return head.next;
        ListNode index = head;
        ListNode pre = null;
        while (index != null) {
            ListNode temp = index.next;
            if (index.val == val) {
                //开始拼接
                pre.next = temp;
                return head;
            }
            pre = index;
            index = temp;
        }
        return head;
    }
}
