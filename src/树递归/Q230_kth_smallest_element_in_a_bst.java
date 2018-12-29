package 树递归;

public class Q230_kth_smallest_element_in_a_bst {
    int count;
    int result;

    public int kthSmallest(TreeNode root, int k) {
        /**
         * 思入:  递归解法:设置一个全局size变量,中序遍历打印第k次,不断相上传递第k个数,否则传递null
         */
        count = k;
        helper(root);
        return result;

    }

    private void helper(TreeNode root) {
        if (root.left != null) helper(root.left);
        count--;
        if (count == 0) result = root.val;
        if (root.right != null) helper(root.right);
    }
}
