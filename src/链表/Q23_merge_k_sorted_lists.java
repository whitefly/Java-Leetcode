package 链表;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Q23_merge_k_sorted_lists {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        /***
         * 思入1:暴力法.全部融合在一个ArrayList中,然后排序,最后沿着这个ArrayList重新生成链表
         */
        //全部融合
        ArrayList<ListNode> container = new ArrayList<>();
        for (ListNode root : lists) {
            while (root != null) {
                container.add(root);
                root = root.next;
            }
        }
        if (container.size() == 0) return null;
        // 排序
        container.sort(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        //重新组链
        for (int i = 0; i < container.size() - 1; i++) {
            ListNode temp = container.get(i);
            temp.next = container.get(i + 1);
        }
        return container.get(0);
    }
}
