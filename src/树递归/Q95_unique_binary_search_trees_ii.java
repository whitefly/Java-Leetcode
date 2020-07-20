package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q95_unique_binary_search_trees_ii {

    public List<TreeNode> generateTrees(int n) {
        /**
         * 思入:  递归函数定义: 返回以[L,R]中所有的搜索二叉树
         */
        if (n == 0) return new ArrayList<>();
        return helper(1, n);
    }

    private List<TreeNode> helper(int L, int R) {
        List<TreeNode> temp = new ArrayList<>();
        if (L > R) {
            temp.add(null);
            return temp;
        }
        for (int i = L; i <= R; i++) {
            final List<TreeNode> lefts = helper(L, L - 1);
            final List<TreeNode> rights = helper(L + 1, R);

            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    final TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    temp.add(root);
                }
            }
        }
        return temp;
    }


    public static void main(String[] args) {
        Q95_unique_binary_search_trees_ii s = new Q95_unique_binary_search_trees_ii();
        List<TreeNode> treeNodes = s.generateTrees(3);
        System.out.println("OK");
    }


}
