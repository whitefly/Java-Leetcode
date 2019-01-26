package 树递归;

public class Q700_search_in_a_binary_search_tree {
    public TreeNode searchBST(TreeNode root, int val) {
        /**
         *思入: 简单的前序遍历,考虑二分查找剪枝
         */
        if (root == null) return null;
        if (root.val == val) return root;
        return (root.val < val) ? searchBST(root.right, val) : searchBST(root.left, val);
    }
}
