package 链表;

public class Q237_delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        /**
         * 思入: 由于得到之前的节点,所以只能考虑对当前节点的内容进行替换. 将下一个节点的值复制到当前节点中
         */

        ListNode next = node.next;
        node.val = next.val;
        node.next = next.next;

    }
}
