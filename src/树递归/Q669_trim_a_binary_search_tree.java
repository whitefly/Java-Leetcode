package 树递归;

public class Q669_trim_a_binary_search_tree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        /**
         * 思入: 假设 左的结果是修建好的,右边也是修剪好的
         */
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);

        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}
