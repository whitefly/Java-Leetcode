package 树递归;

public class Q783_minimum_distance_between_bst_nodes {
    private int result = Integer.MAX_VALUE;
    private int last = Integer.MIN_VALUE+1000000;

    public int minDiffInBST(TreeNode root) {
        /*
        思入: 二叉搜索树,中序遍历就是升序排列,最小差值只可能出现在 2个连续数字之间. 所以中序遍历一遍计算连续2数的最小差值即可
         */
        helper(root);
        return result;
    }

    private void helper(TreeNode root) {
        if (root.left != null) helper(root.left);
        result = Math.min(root.val - last, result);
        last = root.val;
        if (root.right != null) helper(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        Q783_minimum_distance_between_bst_nodes s = new Q783_minimum_distance_between_bst_nodes();
        System.out.println(s.minDiffInBST(root));

    }
}
