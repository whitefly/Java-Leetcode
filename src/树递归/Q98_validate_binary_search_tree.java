package 树递归;

public class Q98_validate_binary_search_tree {
    long last = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root) {
        /**
         * 思入: 设置一个全局变量,表示它的中序遍历中上一个的值
         */
        if (root == null) return true;
        boolean l_ok = isValidBST(root.left);

        if (last < root.val && l_ok) last = root.val;
        else return false;

        boolean r_ok = isValidBST(root.right);

        return r_ok;
    }

}
