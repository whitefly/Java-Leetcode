package 树递归;

import java.util.Arrays;

public class Q105_construct_binary_tree_from_preorder_and_inorder_traversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        /**
         * 思入: 用双指针来确定子树的范围
         **/
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int p_l, int p_r, int[] inorder, int i_l, int i_r) {
        if (p_l > p_r) return null;
        if (p_l == p_r) return new TreeNode(preorder[p_l]);


        //找到前序第一个
        int num = preorder[p_l];
        TreeNode temp = new TreeNode(num);

        //在中序中找到位置,position即为左边部分的元素
        int position = i_l;
        while (inorder[position] != num) position++;

        int left_size = position - i_l;
        temp.left = helper(preorder, p_l + 1, p_l + left_size, inorder, i_l, position - 1);
        temp.right = helper(preorder, p_l + left_size + 1, p_r, inorder, position + 1, i_r);
        return temp;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        Q105_construct_binary_tree_from_preorder_and_inorder_traversal s = new Q105_construct_binary_tree_from_preorder_and_inorder_traversal();
        TreeNode treeNode = s.buildTree(preorder, inorder);
        System.out.println("OK");
    }
}
