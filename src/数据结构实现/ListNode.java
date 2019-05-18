package 数据结构实现;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    /**
     * 根据数组快速创建链表
     *
     * @param nums
     * @return
     */
    public static ListNode createListByArray(int... nums) {
        ListNode first = new ListNode(-1);
        ListNode index = first;
        for (int i = 0; i < nums.length; i++) {
            index.next = new ListNode(nums[i]);
            index = index.next;
        }
        return first.next;
    }

    /**
     * 打印链表的节点值
     *
     * @param root
     */
    public static void printList(ListNode root) {
        int size = 0;
        while (root != null) {
            size++;
            if (size > 100) continue; //防止循环链表的无限打印
            System.out.printf("%d ", root.val);
            root = root.next;
        }
    }

    /**
     * 获取该链表的最后一个节点
     *
     * @param root
     * @return
     */
    public static ListNode getLastNode(ListNode root) {
        if (root == null) return null;
        while (root.next != null) root = root.next;
        return root;
    }

    public static int getListLength(ListNode root) {
        int size = 0;
        while (root != null) {
            size++;
            root = root.next;
        }
        return size;
    }

    public static int getNodeOfIndex(ListNode root, int index) {
        return 1;
    }
}
