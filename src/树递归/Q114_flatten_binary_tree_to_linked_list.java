package 树递归;

import java.util.ArrayList;
import java.util.List;


public class Q114_flatten_binary_tree_to_linked_list {
    List<TreeNode> buffer = new ArrayList<>();


    public void flatten(TreeNode root) {
        /**
         * 思入:树的前序遍历.暴力方法:扫一遍存在数组中(使用了额外的空间),然后扫数组组成链表
         */
        helper(root);
        TreeNode result = new TreeNode(-1);
        TreeNode scan = result;
        for (TreeNode node : buffer) {
            node.left = null;
            scan.right = node;
            scan = node;
        }
    }

    private void helper(TreeNode root) {
        if (root == null) return;
        buffer.add(root);
        helper(root.left);
        helper(root.right);
    }

    public void flatten2(TreeNode root) {
        /**
         * 思想: (不使用额外的空间)使用递归的思想,调用函数后,左子,右子已经成链,需要得到左边的最后一个节点串起来+右边链,然后整体拼接到右边去. 根据左右子的返回结果进行不同的执行
         */
        if (root == null) return;
        helper2(root);
    }

    private TreeNode helper2(TreeNode root) {
        //root不能为null
        TreeNode leftLast = null;
        TreeNode rightLast = null;
        if (root.left != null) leftLast = helper2(root.left);
        if (root.right != null) rightLast = helper2(root.right);


        if (leftLast == null && rightLast == null) {
            //无子时,返回自己
            return root;
        } else if (rightLast == null) {
            //只有左子时
            root.right = root.left;
            root.left = null;
            return leftLast;
        } else if (leftLast == null) {
            //只有右子时
            return rightLast;
        } else {
            //左右都有时
            TreeNode temp = root.right;
            root.right = root.left;
            leftLast.right = temp;
            root.left = null;
            return rightLast;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.right = new TreeNode(6);

        Q114_flatten_binary_tree_to_linked_list s = new Q114_flatten_binary_tree_to_linked_list();
        s.flatten2(null);

        System.out.println("OK");
    }
}
