package 剑指Offer;


public class O68_er_cha_shu_de_zui_jin_gong_gong_zu_xian_lcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //这种递归解放看似简单,实际上很多trick,不符合树递归的递归函数构造思入,无法在面试中从零推出来
        //当时面试时,没有写出来
        if (root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) return root; //目标根节点
        return left == null ? right : left;
    }


}
