package 链表;


public class Q92_reverse_linked_list_ii {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode main = first;

        ListNode second = new ListNode(-1);
        ListNode left = null, leftFront = null;

        int count = 0;
        for (; main != null; count++) {
            ListNode next = main.next;

            if (m - 1 == count) leftFront = main;

            if (m <= count && count <= n) {
                main.next = second;
                second = main;

                if (m == count) left = main;
                if (count == n) {
                    //最后一个,开始拼接
                    left.next = next;
                    leftFront.next = main;
                }
            }
            main = next;
        }
        return first.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        return helper(head, m, n, 1)[0].next;
    }

    private ListNode[] helper(ListNode target, int m, int n, int i) {
        if (target == null) return new ListNode[]{null, null};

        ListNode[] nodes = helper(target.next, m, n, i + 1);
        ListNode first = nodes[0], insert = nodes[1];
        if (first == null) first = new ListNode(-1);
        ListNode choose = (m <= i && i < n) ? insert : first;
        target.next = choose.next;
        choose.next = target;
        return new ListNode[]{first, target};
    }

    public static void main(String[] args) {
        Q92_reverse_linked_list_ii solver = new Q92_reverse_linked_list_ii();
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
        ListNode node = new ListNode(3);
        node.next = new ListNode(5);
//        ListNode result = solver.reverseBetween2(node, 2, 4);
        ListNode result = solver.reverseBetween2(node, 1, 2);
        System.out.println(result);
    }
}
