package 树递归;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q103_binary_tree_zigzag_level_order_traversal {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        /**
         *  思入: 基于层次遍历的方法3:每次只弹出特定量节点, 根据深度来确定加入container的方向
         */
        Queue<TreeNode> Q = new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;
        Q.offer(root);
        boolean flag = true;
        while (!Q.isEmpty()) {
            LinkedList<Integer> container = new LinkedList<>();
            int level_size = Q.size();
            for (int i = 0; i < level_size; i++) {
                TreeNode temp = Q.poll();
                if (flag) container.add(temp.val);
                else container.add(0, temp.val);

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
            flag = !flag;
            result.add(container);
        }
        return result;
    }
}

