package 树递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q515_find_largest_value_in_each_tree_row {
    public List<Integer> largestValues(TreeNode root) {
        /**
         * 思入: 层次遍历,稍微改改即可
         */
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            int level_max = Integer.MIN_VALUE;
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                level_max = Math.max(level_max, temp.val);

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);

            }
            result.add(level_max);
        }
        return result;
    }
}
