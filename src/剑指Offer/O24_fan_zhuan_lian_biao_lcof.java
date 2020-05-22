package 剑指Offer;

public class O24_fan_zhuan_lian_biao_lcof {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode pre = null, index = head, temp;
        while (index != null) {
            temp = index.next;

            index.next = pre;
            pre = index;
            index = temp;
        }
        return pre;
    }
}
