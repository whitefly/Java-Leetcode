package 树递归;

public class Q530_minimum_absolute_difference_in_bst {
    int result = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        /*
        思入: 由于是搜索二叉树,所以尝试要找最接近的.左子树中最大的,找到右子树中最小的.
         */
        helper(root);
        return result;
    }

    private int[] helper(TreeNode root) {
        //返回最大和最小值
        if (root == null) return null;
        int[] LMinMax = helper(root.left);
        int[] RMinMax = helper(root.right);
        int current = root.val;
        if (LMinMax != null & RMinMax != null) {
            int temp = Math.min(current - LMinMax[1], RMinMax[0] - current);
            result = Math.min(result, temp);
            return new int[]{LMinMax[0], RMinMax[1]};
        } else if (LMinMax != null) {
            result = Math.min(result, current - LMinMax[1]);
            return new int[]{LMinMax[0], current};
        } else if (RMinMax != null) {
            result = Math.min(result, RMinMax[0] - current);
            return new int[]{current, RMinMax[1]};
        } else {
            return new int[]{current, current};
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        Q530_minimum_absolute_difference_in_bst s = new Q530_minimum_absolute_difference_in_bst();
        int minimumDifference = s.getMinimumDifference(root);
        System.out.println(minimumDifference);
    }
}
