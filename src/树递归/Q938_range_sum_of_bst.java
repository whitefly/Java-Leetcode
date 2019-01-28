package 树递归;

public class Q938_range_sum_of_bst {
    public int rangeSumBST(TreeNode root, int L, int R) {
        /**
         * 思入: 搜索二叉树的遍历,向上传符合要求的和. 可以做剪枝
         */
        if (root == null) return 0;
        if (root.val < L) return rangeSumBST(root.right, L, R);
        if (R < root.val) return rangeSumBST(root.left, L, R);

        int l_sum = rangeSumBST(root.left, L, R);
        int r_sum = rangeSumBST(root.right, L, R);
        return l_sum + root.val + r_sum;
    }
}
