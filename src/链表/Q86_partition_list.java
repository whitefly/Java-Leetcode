package 链表;

public class Q86_partition_list {
    public ListNode partition(ListNode head, int x) {
        ListNode firstSmall = new ListNode(-1);
        ListNode firstOld = new ListNode(-1);
        ListNode small = firstSmall;

        ListNode last = firstOld;
        ListNode scan = firstOld.next = head;
        while (scan != null) {
            //碰到小于的,转移到新链表,设置next为null,并从原链表中删除.
            if (scan.val < x) {
                small.next = scan;
                small = scan;

                scan = scan.next;
                small.next = null;
                last.next = scan;
            } else {
                scan = scan.next;
                last = last.next;
            }
        }
        //拼接
        small.next = firstOld.next;
        return firstSmall.next;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
//        root.next = new ListNode(4);
//        root.next.next = new ListNode(3);
//        root.next.next.next = new ListNode(2);
//        root.next.next.next.next = new ListNode(5);
//        root.next.next.next.next.next = new ListNode(2);

        Q86_partition_list s = new Q86_partition_list();
        ListNode partition = s.partition(root, 3);
        System.out.println("OK");


    }
}
