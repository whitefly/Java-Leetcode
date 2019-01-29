package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q589_n_ary_tree_preorder_traversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> preorder(Node root) {
        /**
         * 思入: 递归进行前序遍历. 仅仅将二叉树的左右子树 变为 for循环来遍历子树而已
         */
        if (root == null) return result;
        helper(root);
        return result;

    }

    private void helper(Node root) {
        result.add(root.val);
        for (Node child : root.children) if (child != null) helper(child);
    }
}
