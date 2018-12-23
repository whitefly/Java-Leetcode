package 排序;


public class Q148_sort_list {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode sortList(ListNode head) {
        /**
         * 思入: 由于是链表,而为常数空间.
         * 快排否定(因为需要无法做法指针从后向前扫),
         * 基排,堆排否定(因为最快需要o(n))
         * 只剩下:归并!!
         * 归并一遍使用递归完成. 分(递归)+和 2个函数
         * 归并和核心在于找到中间切分点,所以需要快慢指针
         */
        if (head == null) return null;
        return sort_merge(head);
    }

    private ListNode sort_merge(ListNode head) {
        if (head.next == null) return head;

        //快慢指针扫一遍得到中间节点,终止时,slow为中间节点
        ListNode fast_index = head, slow_index = head;
        while (fast_index.next.next != null) {
            slow_index = slow_index.next;
            fast_index = fast_index.next.next;
            if (fast_index.next == null) break;
        }
        //分
        ListNode r_head = slow_index.next;
        slow_index.next = null;
        ListNode l = sort_merge(head);
        ListNode r = sort_merge(r_head);

        //和
        return merge(l, r);
    }

    private ListNode merge(ListNode l1, ListNode l2) {
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

    private ListNode get_list(int[] nums) {
        ListNode root = new ListNode(-1);
        ListNode index = root;
        for (int i = 0; i < nums.length; i++) {
            index.next = new ListNode(nums[i]);
            index = index.next;
        }
        return root.next;
    }

    public static void main(String[] args) {
        Q148_sort_list s = new Q148_sort_list();
        int[] nums = {4, 2, 1, 3};
        ListNode list = s.get_list(nums);
        ListNode r = s.sortList(list);
        System.out.println("OK");
    }
}
