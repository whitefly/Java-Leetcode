package 动态规划;

public class Q337_house_robber_iii {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int rob(TreeNode root) {
        /*
        思入: 和打家劫舍II没什么区别
         也是分2种情况
         情况1: 取根节点
         情况2: 不取根节点
         dp[root][true]= dp[左子][false]+dp[右子][false]+本身;
         dp[root][false]=max(dp[左子][false],dp[右子][true])+max(dp[左子][false],dp[右子][true]);
         */
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode root) {
        if (root == null) {
            return new int[]{0, Integer.MIN_VALUE};
        }
        int[] dpLeft = helper(root.left);
        int[] dpRight = helper(root.right);

        int get = dpLeft[0] + dpRight[0] + root.val;
        int noGet = Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]);
        return new int[]{noGet, get};
    }

    public static void main(String[] args) {

    }
}
