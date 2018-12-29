package 树递归;

public class Q110_balanced_binary_tree {

    public boolean isBalanced(TreeNode root) {
        /**
         *  思入: 得到每个子树的层数,然后进行比较.  由于只能返回层数,所以用返回值-1表示不符合.
         */
        if (root == null) return true;
        return deepth(root) != -1;

    }

    private int deepth(TreeNode root) {
        if (root == null) return 0;
        int l = deepth(root.left);
        int r = deepth(root.right);
        if (l == -1 || r == -1) return -1;
        if (Math.abs(l - r) >= 2) return -1;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(3);

        root.left.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(4);

        Q110_balanced_binary_tree s = new Q110_balanced_binary_tree();
        System.out.println(s.isBalanced(root));
    }

}
