package 哈希;

import java.util.HashMap;
import java.util.Map;

class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {
    }

    public Node(int _val, Node _next, Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}


public class Q138_copy_list_with_random_pointer {
    public Node copyRandomList(Node head) {
        /**
         * 思想: 第一遍,不管随机指针,直接复制链表,使用一个map来作为新旧的节点映射; 第二遍,将随机指针替换为新节点
         */
        Map<Node, Node> map = new HashMap<>();
        Node result = new Node();
        Node index = result;
        while (head != null) {
            Node newNode = new Node(head.val, null, head.random);
            map.put(head, newNode);
            index.next = newNode;
            index = newNode;
            head = head.next;
        }
        //替换新老随机节点
        index = result.next;
        while (index != null) {
            index.random = map.get(index.random);
            index = index.next;
        }
        return result.next;
    }

}
