package 树递归;

public class Q101_symmetric_tree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        /**
         * 思想: 需要验证,对称位置是否一致,即要验证镜像位置的节点是否一致.左右子树--->左右镜像节点. 需要传入左右镜像节点(先把参数写上,先假装可以传入即可)
         */
        if (root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        //终止条件
        boolean l, r;
        if (root1 == null && root2 == null) return true;
        if (root1 != null && root2 != null) {
            if (root1.val != root2.val) return false;
            l = helper(root1.left, root2.right);
            r = helper(root1.right, root2.left);
            return l && r;
        }
        return false;
    }
}
