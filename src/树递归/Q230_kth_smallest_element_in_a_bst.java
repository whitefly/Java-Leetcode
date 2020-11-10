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


    /**
     * 递归+不使用全局变量的解法
     * 只能先对左子节点计数,这种方式效率不好,但符合某些面试官的恶趣味(递归+不适用全局变量)
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest2(TreeNode root, int k) {
        if (root == null) return -1;
        int c = size(root.left);
        if (k <= c) return kthSmallest2(root.left, k);
        if (k > (c + 1)) return kthSmallest2(root.right, k - (c + 1));
        return root.val;
    }

    private int size(TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + 1 + size(root.right);
    }
}
