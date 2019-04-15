package 树递归;

public class C132_2_maximum_difference_between_node_and_ancestor {
    int result = 0;

    public int maxAncestorDiff(TreeNode root) {
        /**
         * 思入: 绝对值最大,本质是要找某一个路径上的最小 和 最大值. 给某个节点设置一个从root节点到此处的[最小值,最大值],然后不断遍历来改变
         */
        if (root != null) helper(root, root.val, root.val);
        return result;
    }

    private void helper(TreeNode root, int min, int max) {
        result = Math.max(max - min, result);
        if (root.left == null && root.right == null) return;
        if (root.left != null) helper(root.left, Math.min(root.left.val, min), Math.max(root.left.val, max));
        if (root.right != null) helper(root.right, Math.min(root.right.val, min), Math.max(root.right.val, max));
    }
}
