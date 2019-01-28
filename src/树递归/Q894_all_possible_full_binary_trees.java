package 树递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q894_all_possible_full_binary_trees {
    public List<TreeNode> allPossibleFBT(int N) {
        /**
         * 思入: 本质和之前树的所有组合一样,就是选一个作为root节点. 然后假设创建子树的功能已经完善
         * 由于是满二叉,需要子节点的数量只可能为0,1,3,5....(即0+奇数)
         */

        List<TreeNode> result = new ArrayList<>();

        if (N == 0) {
            result.add(null);
            return result;
        }
        if (N % 2 == 0) return result;

        for (int l_size = 0; l_size < N; l_size++) {
            //i表示左子树的数量
            TreeNode root;
            int r_size = N - l_size - 1;

            if (l_size != 0 && l_size % 2 == 0) continue;
            if (r_size != 0 && l_size % 2 == 0) continue;

            List<TreeNode> l_list = allPossibleFBT(l_size);
            List<TreeNode> r_list = allPossibleFBT(r_size);

            for (TreeNode l_child : l_list) {
                for (TreeNode r_child : r_list) {
                    root = new TreeNode(0);
                    root.left = l_child;
                    root.right = r_child;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q894_all_possible_full_binary_trees s = new Q894_all_possible_full_binary_trees();
        List<TreeNode> treeNodes = s.allPossibleFBT(1);
        System.out.println("OK");
    }
}
