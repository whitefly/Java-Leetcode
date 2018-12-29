package 树递归;

import java.util.LinkedList;
import java.util.Queue;

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;

    TreeLinkNode(int x) {
        val = x;
    }
}

public class Q116_populating_next_right_pointers_in_each_node {
    public void connect(TreeLinkNode root) {
        /**
         * 思入1: 层次遍历的变种,需要一个last来保存左边节点.方便做链表的拼接
         */
        if (root == null) return;
        Queue<TreeLinkNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            TreeLinkNode last = new TreeLinkNode(-1);
            for (int i = 0; i < size; i++) {
                TreeLinkNode temp = Q.poll();

                last.next = temp;
                last = temp;

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
        }
    }

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);

        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);

        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);

        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);

        Q116_populating_next_right_pointers_in_each_node s = new Q116_populating_next_right_pointers_in_each_node();
        s.connect(root);
        System.out.println("OK");


    }
}
