package 树递归;

import java.util.LinkedList;
import java.util.Queue;

public class Q513_find_bottom_left_tree_value {
    public int findBottomLeftValue(TreeNode root) {
        /**
         * 思入: 层次遍历,找到最底层的第一个. 将每层的第一个动态保存即可
         */

        Queue<TreeNode> Q = new LinkedList<>();
        Q.offer(root);
        int first=-1;
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if (i == 0) first = temp.val;

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
        }
        return first;
    }
}
