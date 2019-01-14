package 树递归;

public class Q235_lowest_common_ancestor_of_a_binary_search_tree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思入: 和二叉树的最近公共祖先的代码没有任何区别.
         */
        if (root == null) return null;
        //后序
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        //根据本身和左右子的情况,选项向上传递的变量
        if (root == p || root == q) return root;
        if (l != null && r != null) return root;
        else if (l != null) return l;
        else if (r != null) return r;
        else return null;
    }
}
