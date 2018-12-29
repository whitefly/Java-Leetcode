package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q257_binary_tree_paths {
    List<String> result = new ArrayList<>();
    StringBuilder container = new StringBuilder();

    public List<String> binaryTreePaths(TreeNode root) {
        /**
         * 思入:  同Q113, 只不过条件没有限制,设置container
         */
        if (root == null) return result;
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        //加入叶节点
        if (root.left == null && root.right == null) {
            int index = container.length();
            container.append(root.val);
            result.add(container.toString());
            container.delete(index, container.length());
            return;
        }
        //加入非叶节点
        int index = container.length();
        container.append(root.val + "->");
        if (root.left != null) helper(root.left);
        if (root.right != null) helper(root.right);
        container.delete(index, container.length());
    }
}
