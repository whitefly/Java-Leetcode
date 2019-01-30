package 树递归;

public class Q450_delete_node_in_a_bst {
    public TreeNode deleteNode(TreeNode root, int key) {
        /**
         * 思入:  删除一个节点,需要取一个节点来代替它. 要不取左子的最大,要不取右子的最小(取右子的即可)
         * 若取右子的最小,需要将最小取出,并且将该点从右子删除,并且返回右子
         */
        if (root == null) return null;  //防止出现key找不到的情况

        if (root.val == key) {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            //左右子不为空的情况,找右子最左边(拼接 左右),并返回
            TreeNode R_min = getMin(root.right);
            R_min.right = deleteMin(root.right);  //注意此时应该先右,后左. 不然会对deleteMin造成影响
            R_min.left = root.left;
            return R_min;
        } else {
            if (key < root.val) root.left = deleteNode(root.left, key);
            else root.right = deleteNode(root.right, key);
            return root;
        }
    }


    private TreeNode getMin(TreeNode root) {
        if (root.left == null) return root;
        return getMin(root.left);
    }

    private TreeNode deleteMin(TreeNode root) {
        if (root.left == null) return root.right;
        root.left = deleteMin(root.left);
        return root;
    }
}
