package 剑指Offer;

import java.util.*;

public class O32ii_cong_shang_dao_xia_da_yin_er_cha_shu_ii_lcof {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rnt = new LinkedList<>();
        Queue<TreeNode> Q = new LinkedList<>();
        if (root != null) Q.add(root);
        boolean direct = true;
        while (!Q.isEmpty()) {
            int size = Q.size();
            List<Integer> line = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = Q.poll();
                if (direct) {
                    line.add(temp.val);
                } else line.add(0, temp.val);

                if (temp.left != null) Q.add(temp.left);
                if (temp.right != null) Q.add(temp.right);
            }
            rnt.add(line);
            direct = !direct;
        }
        return rnt;
    }
}
