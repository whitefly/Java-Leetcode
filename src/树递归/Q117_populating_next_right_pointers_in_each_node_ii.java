package 树递归;

import java.util.LinkedList;
import java.util.Queue;

public class Q117_populating_next_right_pointers_in_each_node_ii {
    public void connect(TreeLinkNode root) {
        /**
         * 思入:和Q117的代码一毛一样
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
}
