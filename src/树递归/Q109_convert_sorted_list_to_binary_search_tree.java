package 树递归;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q109_convert_sorted_list_to_binary_search_tree {
    public TreeNode sortedListToBST(ListNode head) {
        /**
         * 思入: 和Q108差不多,核心是找中间的节点. 需要扫一遍来获取总大小,每次递归传入中间节点的位置长度和链表
         * 思入2: 扫一遍,用数组来存储链表,省去了拼接的问题(有点作弊嫌疑)
         */
        int size = 0;
        ListNode index = head;
        while (index != null) {
            size++;
            index = index.next;
        }
        return helper(head, size);
    }

    private TreeNode helper(ListNode head, int size) {
        if (size <= 0) return null;
        if (size == 1) return new TreeNode(head.val);

        int half = size / 2;
        //last表示中间节点的上一个
        ListNode last = head;
        for (int i = 0; i < half - 1; i++) last = last.next;
        //分离
        ListNode mid = last.next;
        TreeNode root = new TreeNode(mid.val);
        ListNode l_node = head;
        ListNode r_node = mid.next;
        mid.next = null;

        //填充左右子
        root.left = helper(l_node, half);
        root.right = helper(r_node, size - half - 1);
        return root;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(-2);
        ListNode index = head;
        int nums[] = {-10, -3, 0, 5, 9};
        for (int i = 0; i < nums.length; i++) {
            index.next = new ListNode(nums[i]);
            index = index.next;
        }
        head = head.next;

        Q109_convert_sorted_list_to_binary_search_tree s = new Q109_convert_sorted_list_to_binary_search_tree();
        TreeNode root = s.sortedListToBST(head);
        System.out.println("OK");
    }
}
