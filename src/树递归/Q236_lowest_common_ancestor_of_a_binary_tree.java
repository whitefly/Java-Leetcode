package 树递归;

public class Q236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思入:  若左子有,右子有,则它是第一个祖先,不断将它的val向上传
         * 若左子有,右子没有,则父节点标号
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
