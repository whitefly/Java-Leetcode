package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q95_unique_binary_search_trees_ii {
    public List<TreeNode> generateTrees(int n) {
        /**
         * 思入: 递归: 假设左边回传所有的结果,假设右边已经回传所有的结果.只需要选择本轮的root节点,左右组合拼接
         */
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }


    private List<TreeNode> helper(int l, int r) {

        List<TreeNode> result = new ArrayList<>();
        if (l > r) {
            result.add(null);
            return result;
        }

        //找一个作为root节点
        for (int i = l; i <= r; i++) {
            TreeNode root;

            List<TreeNode> l_result = helper(l, i - 1);
            List<TreeNode> r_result = helper(i + 1, r);
            //拼接左右所有可能
            for (TreeNode l_child : l_result) {
                for (TreeNode r_child : r_result) {
                    root = new TreeNode(i);
                    root.left = l_child;
                    root.right = r_child;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q95_unique_binary_search_trees_ii s = new Q95_unique_binary_search_trees_ii();
        List<TreeNode> treeNodes = s.generateTrees(3);
        System.out.println("OK");
    }


}
