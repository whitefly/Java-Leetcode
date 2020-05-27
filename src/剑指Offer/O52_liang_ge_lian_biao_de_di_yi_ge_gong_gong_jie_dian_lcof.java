package 剑指Offer;

public class O52_liang_ge_lian_biao_de_di_yi_ge_gong_gong_jie_dian_lcof {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        //利用A+B+C = B+A+C,若一个指针走到头,回到另一个链表的原点后,多走的恰恰就是距离差
        ListNode index1 = headA, index2 = headB;
        while (index1 != index2) {
            index1 = (index1 == null) ? headB : index1.next;
            index2 = (index2 == null) ? headA : index2.next;
        }
        return index1;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        //找长度差值,然后2个指针同时遍历即可
        if (headA == null || headB == null) return null;
        int count1 = 0;
        int count2 = 0;
        ListNode index1 = headA, index2 = headB;
        while (index1 != null) {
            count1++;
            index1 = index1.next;
        }
        while (index2 != null) {
            count2++;
            index2 = index2.next;
        }
        //较长链的指针先走
        ListNode fast, slow;
        if (count1 > count2) {
            fast = headA;
            slow = headB;
        } else {
            fast = headB;
            slow = headA;
        }
        int gap = Math.abs(count1 - count2);
        while (gap > 0) {
            fast = fast.next;
            gap--;
            if (fast == null) return null;
        }
        //同时遍历
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
            if (fast == null || slow == null) return null;
        }
        return slow;
    }

}
