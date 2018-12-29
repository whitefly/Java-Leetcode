package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q113_path_sum_ii {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        /**
         * 思入: 类似于回缩剪枝的思入,需要一个container来进行动态变换
         */
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> container = new ArrayList<>();
        if (root == null) return result;
        container.add(root.val);
        helper(root, sum, result, container);
        return result;
    }

    private void helper(TreeNode root, int sum, List<List<Integer>> r, ArrayList<Integer> c) {
        if (root.left == null && root.right == null) {
            if (sum == root.val) r.add((List<Integer>) c.clone());
            return;
        }
        //遍历左右子树
        TreeNode[] temp = {root.left, root.right};
        for (TreeNode child : temp) {
            if (child == null) continue;
            c.add(child.val);
            helper(child, sum - root.val, r, c);
            c.remove(c.size() - 1);
        }
    }
}
