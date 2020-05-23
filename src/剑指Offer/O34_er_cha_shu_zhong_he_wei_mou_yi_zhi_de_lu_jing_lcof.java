package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class O34_er_cha_shu_zhong_he_wei_mou_yi_zhi_de_lu_jing_lcof {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root != null) helper(root, 0, sum, new ArrayList<>());
        return result;
    }

    public void helper(TreeNode root, int accum, int sum, List<Integer> temp) {
        temp.add(root.val);
        if (root.left == null && root.right == null) {
            if ((accum + root.val) == sum) {
                result.add((List<Integer>) ((ArrayList) temp).clone());
            }
        } else {
            //非叶子节点
            if (root.left != null) helper(root.left, accum + root.val, sum, temp);
            if (root.right != null) helper(root.right, accum + root.val, sum, temp);
        }
        temp.remove(temp.size() - 1);
    }
}
