package 链表;


import java.util.Arrays;
import java.util.List;

public class Q234_palindrome_linked_list {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode set_node(List<Integer> l) {
        ListNode root = new ListNode(-1);
        ListNode head = root;

        for (var e : l) {
            ListNode temp = new ListNode(e);
            head.next = temp;
            head = temp;
        }
        return root.next;
    }

    public boolean isPalindrome(ListNode head) {
        /**
         *思入: 由于不能用额外的空间,所以无法存储全部数据然后比较
         * 尝试1: 反转一半的链表, 然后通向遍历.所以需要先得到链表长度
         */
        int size = 0;
        ListNode index = head;
        while (index != null) {
            index = index.next;
            size++;
        }
        if (size == 1 || size == 0) return true;

        //反转一半的节点
        int half_size = size / 2;
        index = head; //本轮指向指向的节点
        ListNode last = null; //本轮结束后指向本轮的节点
        for (int i = 0; i < half_size; i++) {
            //下一轮要指向的node
            ListNode next = index.next;

            //记录last节点
            index.next = last;
            last = index;

            index = next;
        }

        //同向遍历,一旦发现不同,返回
        if (size % 2 == 1) index = index.next;
        while (index != null) {
            int num1 = last.val;
            int num2 = index.val;
            if (num1 != num2) return false;

            index = index.next;
            last = last.next;
        }
        return true;
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 2);
        Q234_palindrome_linked_list s = new Q234_palindrome_linked_list();
        ListNode root = s.set_node(l);
        System.out.println(s.isPalindrome(root));
    }
}

