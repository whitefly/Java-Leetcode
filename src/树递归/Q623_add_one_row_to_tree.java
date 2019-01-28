package 树递归;

public class Q623_add_one_row_to_tree {

    private int depth = 1;

    public TreeNode addOneRow(TreeNode root, int v, int d) {
        /**
         * 思入:   通过先序遍历,找到d-1层,然后修改子节点即可(直接return,不用再继续遍历子节点)
         */
        if (d == 1) {
            TreeNode new_root = new TreeNode(v);
            new_root.left = root;
            return new_root;
        }
        helper(root, v, d);
        return root;

    }

    private void helper(TreeNode root, int v, int d) {
        if (d - 1 == depth) {
            TreeNode temp_l = new TreeNode(v);
            TreeNode temp_r = new TreeNode(v);
            temp_l.left = root.left;
            temp_r.right = root.right;
            root.left = temp_l;
            root.right = temp_r;
            return;
        }

        depth++;
        if (root.left != null) helper(root.left, v, d);
        if (root.right != null) helper(root.right, v, d);
        depth--;
    }
}
