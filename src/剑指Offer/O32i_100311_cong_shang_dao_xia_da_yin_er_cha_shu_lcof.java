package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class O32i_100311_cong_shang_dao_xia_da_yin_er_cha_shu_lcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        //层次遍历写法
        List<Integer> rnt = new ArrayList<>();
        Queue<TreeNode> Q = new LinkedList<>();

        if (root != null) Q.add(root);
        while (!Q.isEmpty()) {
            int size = Q.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                rnt.add(temp.val);
                if (temp.left != null) Q.add(temp.left);
                if (temp.right != null) Q.add(temp.right);
            }
        }
        int[] ints = new int[rnt.size()];
        for (int i = 0; i < ints.length; i++) ints[i] = rnt.get(i);
        return ints;
    }
}
