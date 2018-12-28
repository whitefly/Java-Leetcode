package 树递归;

public class Q104_maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        /**
         * 思入: 普通树递归, 传回子树的层数即可
         */
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        return Math.max(l, r) + 1;

    }
}
