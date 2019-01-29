package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q590_n_ary_tree_postorder_traversal {
    List<Integer> result = new ArrayList<>();

    public List<Integer> postorder(Node root) {
        /**
         * 思入: 递归进行前序遍历. 仅仅将二叉树的左右子树 变为 for循环来遍历子树而已
         */
        if (root == null) return result;
        helper(root);
        return result;
    }

    private void helper(Node root) {
        for (Node child : root.children) if (child != null) helper(child);
        result.add(root.val);
    }
}
