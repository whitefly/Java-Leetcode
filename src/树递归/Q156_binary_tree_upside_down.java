package 树递归;

public class Q156_binary_tree_upside_down {
    public TreeNode upsideDownBinaryTree(TreeNode root) {

        //前序遍历
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode treeNode = upsideDownBinaryTree(root.left);
        TreeNode left = root.left;
        left.left = root.right;
        left.right = root;

        root.left = null;
        root.right = null;
        return treeNode;
    }
}
