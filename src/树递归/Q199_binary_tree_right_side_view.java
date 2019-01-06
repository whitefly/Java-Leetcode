package 树递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q199_binary_tree_right_side_view {
    public List<Integer> rightSideView(TreeNode root) {
        /**
         *  思入: 层次遍历,每次收集最后一个
         */
        Queue<TreeNode> Q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root!=null)return result;

        Q.offer(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if (i == size - 1) result.add(temp.val);
                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
        }
        return result;
    }
}
