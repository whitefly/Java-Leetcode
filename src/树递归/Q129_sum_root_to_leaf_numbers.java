package 树递归;

public class Q129_sum_root_to_leaf_numbers {
    int result = 0;

    public int sumNumbers(TreeNode root) {
        /**
         * 思入: temp存入每个路径.到底时变为数字
         */
        if (root == null) return 0;
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            result += sum * 10 + root.val;
            return;
        }
        sum = sum * 10 + root.val;
        if (root.left != null) helper(root.left, sum);
        if (root.right != null) helper(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        Q129_sum_root_to_leaf_numbers s = new Q129_sum_root_to_leaf_numbers();
        int i = s.sumNumbers(root);
        System.out.println(i);
    }
}
