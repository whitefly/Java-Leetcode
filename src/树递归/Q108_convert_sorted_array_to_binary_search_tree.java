package 树递归;

import java.util.Arrays;

public class Q108_convert_sorted_array_to_binary_search_tree {


    public TreeNode sortedArrayToBST(int[] nums) {
        /**
         * 思入: 用已知序列来构建平衡树, 有一种思入根本不需要翻转.即将 子序列平均分给左右子树,一样构建的树,一定是平衡的
         */
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int l, int r) {
        if (l > r) return null;
        if (l == r) return new TreeNode(nums[l]);

        int mid = (l + r) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, l, mid - 1);
        root.right = helper(nums, mid + 1, r);
        return root;
    }


    public static void main(String[] args) {
        int nums[] = {-10, -3, 0, 5, 9};
        Q108_convert_sorted_array_to_binary_search_tree s = new Q108_convert_sorted_array_to_binary_search_tree();
        TreeNode treeNode = s.sortedArrayToBST(nums);
        System.out.println("OK");
    }
}
