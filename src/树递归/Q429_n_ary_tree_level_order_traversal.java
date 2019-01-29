package 树递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

public class Q429_n_ary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(Node root) {
        /**
         * 思入: 多叉树的层次遍历,和二叉树的层次遍历写法没什么区别
         */
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node now = Q.poll();
                temp.add(now.val);
                for (Node one : now.children) {
                    if (one == null) continue;
                    Q.offer(one);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
