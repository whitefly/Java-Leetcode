package 树递归;

public class Q543_diameter_of_binary_tree {
    int result = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        /**
         * 思入: 计算单个子树的直径. 左+右  向上传递单个路径最大
         */
        helper(root);
        return result;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l_max = helper(root.left);
        int r_max = helper(root.right);
        result = Math.max(result, l_max + r_max);
        return Math.max(l_max, r_max) + 1;
    }

    public static void main(String[] args) {
        Q543_diameter_of_binary_tree s = new Q543_diameter_of_binary_tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        System.out.println(s.diameterOfBinaryTree(root));
    }


}
