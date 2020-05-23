package 剑指Offer;

public class O28_dui_cheng_de_er_cha_shu_lcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    boolean helper(TreeNode L, TreeNode R) {
        if (L == null && R == null) return true;
        else if (L != null && R != null) {
            return L.val == R.val && helper(L.left, R.right) && helper(L.right, R.left);
        }
        return false;
    }
}
