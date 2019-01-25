package 树递归;

public class Q563_binary_tree_tilt {
    int result = 0;

    public int findTilt(TreeNode root) {
        /**
         * 思入:  一个简单的树递归
         */
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;

        int sum_l = helper(root.left);
        int sum_r = helper(root.right);
        result += Math.abs(sum_l - sum_r);
        return sum_l + sum_r + root.val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Q563_binary_tree_tilt s = new Q563_binary_tree_tilt();
        int r = s.findTilt(root);
        System.out.println(r);

    }
}
