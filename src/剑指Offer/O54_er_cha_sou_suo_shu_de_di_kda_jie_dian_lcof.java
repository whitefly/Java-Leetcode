package 剑指Offer;

public class O54_er_cha_sou_suo_shu_de_di_kda_jie_dian_lcof {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int rank;
    int result = -1;
    int id = 0;

    public int kthLargest(TreeNode root, int k) {
        rank = k;
        helper(root);
        return result;
    }

    void helper(TreeNode root) {
        if (rank < id || root == null) return;
        helper(root.right);
        id++;
        if (rank == id) result = root.val;
        helper(root.left);
    }

}
