package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class O35_fu_za_lian_biao_de_fu_zhi_lcof {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        //遍历2遍,1次主链,1次random;
        Map<Node, Node> map = new HashMap<>();
        Node index1 = head;
        Node copy = new Node(-1);
        Node index2 = copy;
        while (index1 != null) {
            Node copyItem = new Node(index1.val);
            map.put(index1, copyItem);
            index2.next = copyItem;
            index2 = index2.next;
            index1 = index1.next;
        }
        //增加随机链
        index1 = head;
        index2 = copy.next;
        while (index1 != null) {
            index2.random = map.getOrDefault(index1.random, null);
            index1 = index1.next;
            index2 = index2.next;
        }
        return copy.next;

    }


}
