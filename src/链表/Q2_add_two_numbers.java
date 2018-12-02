package 链表;


public class Q2_add_two_numbers {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思入: 依次相加,直到某个链表先没有,然后拼接到l1上. 假设l1总是长链,或者等链. 若出现l2长链的情况,将l1和l2的后面的链交换
         * 复杂度: 时间复杂度(O(max(m,n))),空间复杂度:O(1)
         */

        ListNode head1 = l1;
        ListNode head2 = l2, last = null;
        int carry = 0;
        while (head1 != null || head2 != null) {
            int temp1 = head1.val;
            int temp2 = (head2 != null) ? head2.val : 0;

            int sum = temp1 + temp2 + carry;
            head1.val = sum % 10;
            carry = sum / 10;

            //出现l2为长链的情况,进行交换.
            if (head1.next == null && head2 != null && head2.next != null) {
                head1.next = head2.next;
                head2.next = null;
            }


            last = head1;//用来拼接最后新增那个
            head1 = head1.next;
            head2 = (head2 != null) ? head2.next : null;
        }

        // 处理剩下的carry
        if (carry != 0) last.next = new ListNode(carry);
        return l1;

    }

    public static void main(String args[]) {
        ListNode l1 = new ListNode(0);

        ListNode l2 = new ListNode(7);
        l2.next = new ListNode(3);

        l1 = addTwoNumbers(l1, l2);

        System.out.println("ok");


    }

}
