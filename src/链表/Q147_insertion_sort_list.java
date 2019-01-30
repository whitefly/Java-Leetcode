package 链表;

public class Q147_insertion_sort_list {
    public ListNode insertionSortList(ListNode head) {
        /**
         * 思入:  设置一个指针,表示要正在遍历的元素.  然后从左向右去查找正确的位置,然后交换2者的位置
         */
        ListNode index = head;
        ListNode leader = new ListNode(Integer.MIN_VALUE);

        while (index != null) {
            ListNode next = index.next;

            //寻找
            ListNode position = leader;
            while (position.val <= index.val && position.next != null && position.next.val <= index.val) position = position.next;

            //拼接
            index.next = position.next;
            position.next = index;

            index = next;
        }
        return leader.next;
    }

    public static void main(String[] args) {

        ListNode header = new ListNode(-1);
        header.next = new ListNode(5);
        header.next.next = new ListNode(3);
        header.next.next.next = new ListNode(4);
        header.next.next.next.next = new ListNode(0);


        Q147_insertion_sort_list s = new Q147_insertion_sort_list();
        ListNode listNode = s.insertionSortList(header);
        System.out.println("OK");

    }
}
