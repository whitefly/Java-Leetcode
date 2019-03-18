package 树递归;

import java.util.ArrayList;
import java.util.Arrays;

public class Q106_construct_binary_tree_from_inorder_and_postorder_traversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode helper(int[] inorder, int inLeft, int inRight, int[] postorder, int postLeft, int postRight) {
        if (inLeft > inRight) return null;
        //找根节点
        int rootVal = postorder[postRight];
        TreeNode root = new TreeNode(rootVal);
        //拆分
        int position = inLeft;
        while (inorder[position] != rootVal) position++;
        int leftSize = position - inLeft;
        root.left = helper(inorder, inLeft, position - 1, postorder, postLeft, postLeft + (leftSize - 1));
        root.right = helper(inorder, position + 1, inRight, postorder, postLeft + leftSize, postRight - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};
        Q106_construct_binary_tree_from_inorder_and_postorder_traversal s = new Q106_construct_binary_tree_from_inorder_and_postorder_traversal();
        s.buildTree(inorder, postorder);
    }
}
