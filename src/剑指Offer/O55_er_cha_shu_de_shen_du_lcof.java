package 剑指Offer;

public class O55_er_cha_shu_de_shen_du_lcof {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int l = maxDepth(root.left);
        int r = maxDepth((root.right));
        return Math.max(l, r) + 1;

    }
}
