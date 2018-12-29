package 树递归;

import java.util.LinkedList;
import java.util.Queue;

public class Q671_second_minimum_node_in_a_binary_tree {
    int result = -1;
    int init_val;

    public int findSecondMinimumValue(TreeNode root) {
        /**
         *思入: 所有跟初始节点的val不同的值可以参与竞选. 最后取最小的那个.前中后序都可以
         *
         * 错误思入:层次遍历, 若某一层中出现和根节点不同的值,则扫完这层就可以终止,不需要继续扫下一层了. 第2小值可以在最底层,必须全扫一遍
         */
        init_val = root.val;
        hepler(root);
        return result;
    }

    private void hepler(TreeNode root) {
        if (root.left != null) hepler(root.left);

        if (root.val != init_val) {
            if (result == -1) result = root.val;
            else result = Math.min(result, root.val);
        }
        if (root.right != null) hepler(root.right);
    }


}
