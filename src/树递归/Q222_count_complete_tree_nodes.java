package 树递归;

public class Q222_count_complete_tree_nodes {

    public int countNodes(TreeNode root) {
        /**
         * 思入: 树的二分搜索. 左√右✘时,返回左子的val即可
         */
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }


}
