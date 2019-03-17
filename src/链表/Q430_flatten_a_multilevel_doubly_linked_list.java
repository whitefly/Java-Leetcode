package 链表;

import java.util.Stack;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {
    }

    public Node(int _val, Node _prev, Node _next, Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
}

public class Q430_flatten_a_multilevel_doubly_linked_list {
    /**
     * 思入: 出现了subnode,就将其next节点进入stack,设置一个index作为遍历指针+拼接.
     * 需要考虑3种情况, 有child, 有next, stack还含有元素
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        if (head == null) return null;

        Stack<Node> stack = new Stack<>();
        Node index = head;
        while (index.next != null || index.child != null || !stack.isEmpty()) {
            //若出现子节点,入栈,修改其next为child,原child变为null
            if (index.child != null) {
                if (index.next != null) stack.push(index.next);
                Node child = index.child;
                //拼接
                index.next = child;
                index.child = null;
                child.prev = index;
            } else if (index.next == null) {
                Node top = stack.pop();
                //拼接
                top.prev = index;
                index.next = top;
            }
            index = index.next;
        }
        return head;
    }
}
