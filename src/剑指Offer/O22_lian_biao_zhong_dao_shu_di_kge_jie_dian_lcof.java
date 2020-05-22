package 剑指Offer;

public class O22_lian_biao_zhong_dao_shu_di_kge_jie_dian_lcof {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        //快慢指针
        ListNode slow = head, fast = head;
        while (k > 1) {
            fast = fast.next;
            k--;
        }
        //同时移动
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static void main(String[] args) {

    }
}
