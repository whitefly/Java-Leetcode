package 链表;


public class Q21_merge_two_sorted_lists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         *思入: 需要设置3个指针: l1和l2的2个指针,新的节点尾指针
         */
        ListNode root = new ListNode(-1);
        ListNode index1 = l1, index2 = l2, index3 = root;
        while (index1 != null && index2 != null) {
            int num1 = index1.val, num2 = index2.val;
            if (num1 <= num2) {
                index3.next = index1;
                index1 = index1.next;
            } else {
                index3.next = index2;
                index2 = index2.next;
            }
            index3 = index3.next;
        }
        //拼接剩下的
        index3.next = (index1 != null) ? index1 : index2;
        return root.next;

    }
}
