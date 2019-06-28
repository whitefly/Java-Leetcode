package 堆;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q23_merge_k_sorted_lists {


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

    public ListNode mergeKLists2(ListNode[] lists) {
        /**
         * 思入: 使用堆的思想来完成比较(进阶版是胜者树和败者树)
         */
        int k = lists.length;
        if (k < 1) return null;
        PriorityQueue<Integer> heap = new PriorityQueue<>(k, Comparator.comparingInt(o -> lists[o].val));

        //加入k个元素下标
        for (int i = 0; i < k; i++) {
            if (lists[i] != null) heap.add(i);
        }

        ListNode result = new ListNode(-1);
        ListNode index = result;
        while (!heap.isEmpty()) {
            //移除堆顶
            Integer group = heap.poll();
            index.next = lists[group];

            index = index.next;
            lists[group] = lists[group].next;
            if (lists[group] != null) {
                heap.add(group);
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
//        ListNode[] nums = new ListNode[3];
//
//        nums[0] = new ListNode(1);
//        nums[0].next = new ListNode(4);
//        nums[0].next.next = new ListNode(5);
//
//
//        nums[1] = new ListNode(1);
//        nums[1].next = new ListNode(3);
//        nums[1].next.next = new ListNode(4);
//
//        nums[2] = new ListNode(2);
//        nums[2].next = new ListNode(6);

        ListNode[] nums = new ListNode[0];

        Q23_merge_k_sorted_lists s = new Q23_merge_k_sorted_lists();
        ListNode listNode = s.mergeKLists2(nums);

        while (listNode != null) {
            System.out.printf("%d->", listNode.val);
            listNode = listNode.next;
        }

    }
}
