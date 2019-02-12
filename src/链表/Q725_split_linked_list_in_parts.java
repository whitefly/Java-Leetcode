package 链表;

public class Q725_split_linked_list_in_parts {
    public ListNode[] splitListToParts(ListNode root, int k) {
        /**
         * 思入: 核心就是计算出每段的长度,来方法截取尾部为null   基本长度+额外长度
         */
        int size = 0;
        ListNode index = root;
        while (index != null) {
            index = index.next;
            size++;
        }
        int group_size = size / k;
        int rest = size % k;

        ListNode[] result = new ListNode[k];
        ListNode first = new ListNode(-1);
        first.next = root;
        //分离每一段
        for (int i = 0; i < k; i++) {
            result[i] = first.next;
            ListNode tail = first;

            //设置尾部为null
            int temp_size = group_size + (--rest >= 0 ? 1 : 0);  //计算每段长度
            for (int j = 0; j < temp_size; j++) tail = tail.next;
            first.next = tail.next;
            tail.next = null;
        }
        return result;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(-1);
        ListNode index = root;
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        for (int num : nums) {
            index.next = new ListNode(num);
            index = index.next;
        }

        Q725_split_linked_list_in_parts s = new Q725_split_linked_list_in_parts();
        ListNode[] listNodes = s.splitListToParts(root.next, 3);
        System.out.println("OK");

    }
}
