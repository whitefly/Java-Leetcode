package 树递归;

import java.util.HashSet;
import java.util.Set;

public class Q653_two_sum_iv_input_is_a_bst {
    private Set<Integer> set = new HashSet<>();
    boolean result = false;

    public boolean findTarget(TreeNode root, int k) {
        /*
           思入1: 2sum的hash解法+中序遍历
         */
        helper(root, k);
        return result;
    }

    private void helper(TreeNode root, int k) {
        if (root == null || result) return;
        if (root.left != null) helper(root.left, k);
        if (set.contains(root.val)) {
            result = true;
        } else {
            set.add(k - root.val);
        }
        if (root.right != null) helper(root.right, k);
    }
}
