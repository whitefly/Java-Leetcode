package 树递归;

public class Q100_same_tree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        /**
         * 思入: 2个指针同时移动
         */
        if (p == null && q == null) return true;
        if (p != null && q != null) {
            if (p.val != q.val) return false;
            boolean left = isSameTree(p.left, q.left);
            boolean right = isSameTree(p.right, q.right);
            return left && right;
        }
        return false;
    }


}
