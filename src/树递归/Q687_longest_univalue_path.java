package 树递归;

public class Q687_longest_univalue_path {
    /*
     * 思入: 后序遍历, 返回子节点 值的连续情况
     */
    int result = 0;

    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return result == 0 ? 0 : result - 1;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;
        int LLong = helper(root.left);
        int RLong = helper(root.right);
        int LMax = 0, RMax = 0;
        if (root.left != null && root.left.val == root.val) LMax = LLong;
        if (root.right != null && root.right.val == root.val) RMax = RLong;
        result = Math.max(result, LMax + RMax + 1);
        return Math.max(LMax, RMax) + 1;
    }
}
