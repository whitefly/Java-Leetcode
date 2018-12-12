package 链表;


import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q445_add_two_numbers_ii {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        /**
         * 思入:不让反转,就把链表遍历复制到数组中在翻转,可以用stack来简单翻转操作
         */
        // 复制
        Stack<Integer> num1 = new Stack<>(), num2 = new Stack<>();
        int size1 = 0, size2 = 0;
        while (l1 != null) {
            num1.push(l1.val);
            l1 = l1.next;
            size1++;
        }
        while (l2 != null) {
            num2.push(l2.val);
            l2 = l2.next;
            size2++;
        }
        // 相加
        int max_size = Math.max(size1, size2);
        int[] result = new int[max_size + 1];
        int carry = 0, temp, a, b;
        for (int i = 0; i < max_size; i++) {
            a = i < size1 ? num1.pop() : 0;
            b = i < size2 ? num2.pop() : 0;
            temp = carry + a + b;
            result[i] = temp % 10;
            carry = temp / 10;
        }
        if (carry != 0) result[max_size++] = carry;
        //生成新链表
        ListNode root = new ListNode(-1);
        ListNode index = root;
        for (int i = max_size - 1; i >= 0; i--) {
            ListNode now = new ListNode(result[i]);
            index.next = now;
            index = now;
        }
        return root.next;
    }
}
