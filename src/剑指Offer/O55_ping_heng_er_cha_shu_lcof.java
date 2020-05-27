package 剑指Offer;

public class O55_ping_heng_er_cha_shu_lcof {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    boolean result = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return result;
    }

    int helper(TreeNode root) {
        if (!result || root == null) return 0;
        int L = helper(root.left);
        int R = helper(root.right);
        if (Math.abs(L - R) > 1) result = false;
        return Math.max(L, R) + 1;
    }
}
