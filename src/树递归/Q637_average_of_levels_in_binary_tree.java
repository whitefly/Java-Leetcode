package 树递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q637_average_of_levels_in_binary_tree {
    public List<Double> averageOfLevels(TreeNode root) {
        /**
         * 思入: 普通层次遍历的变种,将container变为sum遍历而已
         */
        Queue<TreeNode> Q = new LinkedList<>();
        List<Double> result = new ArrayList<>();
        if (root == null) return result;

        Q.offer(root);
        while (!Q.isEmpty()) {
            int temp_count = Q.size();
            double sum = 0;
            for (int i = 0; i < temp_count; i++) {
                TreeNode temp = Q.poll();
                sum += temp.val;

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
            result.add(sum / temp_count);
        }
        return result;
    }
}
