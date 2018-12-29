package 树递归;

public class Q112_path_sum {
    public boolean hasPathSum(TreeNode root, int sum) {
        /**
         *  思入:给每个root一个目标,任务达到,则返回true, 一旦左右子有一个满足,则继续向上传true
         *  坑点:
         */
        if (root == null) return false;
        if (root.left == null && root.right == null) return root.val == sum;

        boolean l = false, r = false;
        if (root.left != null) l = hasPathSum(root.left, sum - root.val);
        if (root.right != null) r = hasPathSum(root.right, sum - root.val);
        return l || r;
    }


}
