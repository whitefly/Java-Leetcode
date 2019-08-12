package 链表;

public class Q328_odd_even_linked_list {
    public ListNode oddEvenList(ListNode head) {
        /*
         思入: 准备奇和偶的头节点
         */
        ListNode even = new ListNode(-1), odd = new ListNode(-1);
        ListNode scan = head, evenIndex = even, oddIndex = odd;
        for (boolean flag = true; scan != null; scan = scan.next, flag = !flag) {
            if (flag) {
                evenIndex.next = scan;
                evenIndex = evenIndex.next;
            } else {
                oddIndex.next = scan;
                oddIndex = oddIndex.next;
            }
        }
        //拼接
        evenIndex.next = odd.next;
        oddIndex.next = null;
        return even.next;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        ListNode root = new ListNode(-1);
        ListNode index = root;
        for (int i = 0; i < nums.length; i++, index = index.next) {
            index.next = new ListNode(nums[i]);
        }
        Q328_odd_even_linked_list s = new Q328_odd_even_linked_list();
        root = root.next;
        s.oddEvenList(root);
        System.out.println("OK");
    }
}
