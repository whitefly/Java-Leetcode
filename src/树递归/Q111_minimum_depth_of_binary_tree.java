package 树递归;

public class Q111_minimum_depth_of_binary_tree {
    public int minDepth(TreeNode root) {
        /**
         * 思入: 传入子树的层树即可,
         * 注意  1  的深度是2,而不是1, 所以需要考虑只有只有单子的情况(若只有单子,但单子的深度走)
         *     /
         *   2
         */
        if (root == null) return 0;
        int l = minDepth(root.left);
        int r = minDepth(root.right);

        if (l != 0 && r != 0) return Math.min(l, r) + 1;
        else return Math.max(l, r) + 1;
    }

}
