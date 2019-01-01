package 树递归;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q145_binary_tree_postorder_traversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        Stack<TreeNode> S = new Stack<>();
        Stack<Integer> Status = new Stack<>();
        List<Integer> r = new ArrayList<>();
        if (root == null) return r;

        S.push(root);
        Status.push(0);

        while (!S.empty()) {
            TreeNode temp = S.pop();
            int s = Status.pop();
            if (s == 0) {
                S.push(temp);
                Status.push(1);
                if (temp.left != null) {
                    S.push(temp.left);
                    Status.push(0);
                }
            } else if (s == 1) {
                if (temp.right != null) {
                    S.push(temp);
                    Status.push(-1);
                    S.push(temp.right);
                    Status.push(0);
                } else {
                    r.add(temp.val);
                }
            } else {
                r.add(temp.val);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        Q145_binary_tree_postorder_traversal s = new Q145_binary_tree_postorder_traversal();
        List<Integer> r = s.postorderTraversal(root);
        System.out.println(r);
    }
}
