package 树递归;

import java.util.*;

public class Q107_binary_tree_level_order_traversal_ii {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        /**
         * 思入1: 基于层次遍历的思入2,仅仅将最后结果反转下
         */
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        preOrder(root, level, result);
        Collections.reverse(result);
        return result;
    }

    private void preOrder(TreeNode root, int level, List<List<Integer>> lists) {
        if (root == null) return;
        if (lists.size() - 1 < level) lists.add(new ArrayList<>());
        lists.get(level).add(root.val);
        level++;
        preOrder(root.left, level, lists);
        preOrder(root.right, level, lists);
    }

    public List<List<Integer>> levelOrderBottom2(TreeNode root) {
        /**
         * 思入2: 基于层次遍历的思入3,将每次从头将container将入结果集,需要将result设置为LinkedList(这样从头插入比较快)
         */
        Queue<TreeNode> Q = new LinkedList();
        List<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Q.offer(root);
        while (!Q.isEmpty()) {
            int temp_count = Q.size();
            ArrayList<Integer> container = new ArrayList<>();
            for (int i = 0; i < temp_count; i++) {
                TreeNode temp = Q.poll();
                container.add(temp.val);  //出栈时加入结果集

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
            result.add(0, container);
        }
        return result;
    }

}
