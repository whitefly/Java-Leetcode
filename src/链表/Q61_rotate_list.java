package 链表;

public class Q61_rotate_list {
    public ListNode rotateRight(ListNode head, int k) {
        /**
         * 思入: 循环链表的思想. 注意k可能为大于链表长度. 设置一个last指针,目的是最后设置.next=null
         */

        if (head == null) return null;
        //计算长度
        ListNode last = head;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }
        last.next = head;

        //找到新的头结点
        k = size - k % size;
        for (int i = 0; i < k; i++) {
            head = head.next;
            last = last.next;
        }
        //拼接
        last.next = null;
        return head;

    }
}
