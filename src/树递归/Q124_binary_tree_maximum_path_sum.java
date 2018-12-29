package 树递归;

public class Q124_binary_tree_maximum_path_sum {
    int result = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        /**
         * 思入: 只有左右2个路径都是最大的,相加才是最大的.
         * 向上传什么: 经过本节点的最大分支路径(即 左分支+节点 or 右分支+节点 or 节点)
         * 扫遍所有节点,找到最大的,需要一个全局变量,来存储最大结果
         */
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int l = helper(root.left);
        int r = helper(root.right);

        if (l >= 0 && r >= 0) {
            result = Math.max(result, root.val + l + r);
            return root.val + Math.max(l, r);
        }
        if (l >= 0) {
            result = Math.max(result, root.val + l);
            return root.val + l;
        }
        if (r >= 0) {
            result = Math.max(result, root.val + r);
            return root.val + r;
        }
        result = Math.max(result, root.val);
        return root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-1);
        root.right = new TreeNode(9);

        root.right.left = new TreeNode(-6);
        root.right.right = new TreeNode(3);

        root.right.right.right = new TreeNode(-2);

        Q124_binary_tree_maximum_path_sum s = new Q124_binary_tree_maximum_path_sum();
        int i = s.maxPathSum(root);
        System.out.println(i);

    }
}
