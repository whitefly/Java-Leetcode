package 树递归;

public class Q572_subtree_of_another_tree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        /**
         * 思入: 设置一个判断相同树的函数. 若不相同,则看其左树是否成立 若左子树不行,看右子树行不行
         */
        if (isSameTree(s, t)) return true;
        if (s.left != null) if (isSubtree(s.left, t)) return true;
        if (s.right != null) if (isSubtree(s.right, t)) return true;
        return false;
    }

    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null) return false;
        if (t == null) return false;

        if (s.val != t.val) return false;
        else return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
}
