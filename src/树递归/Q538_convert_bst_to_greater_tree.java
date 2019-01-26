package 树递归;

public class Q538_convert_bst_to_greater_tree {
    int sum = 0;

    public TreeNode convertBST(TreeNode root) {
        /**
         * 思入:  二叉搜索树     右->中->左  右边就是比它的节点值之和.  向上回传子树节点和
         */
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        helper(root.right);
        sum += root.val;
        root.val = sum;
        helper(root.left);
    }
}
