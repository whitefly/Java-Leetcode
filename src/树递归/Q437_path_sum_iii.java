package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q437_path_sum_iii {
    private int count = 0;
    private int path_sum = 0;
    private List<Integer> path = new ArrayList<>();

    public int pathSum(TreeNode root, int sum) {
        /**
         *  思入: 得到 path 和 sum, 然后推算出所有累积和.然后进行判断. (没有任何剪枝)
         */
        helper(root, sum);
        return count;
    }

    private void helper(TreeNode root, int target) {
        if (root == null) return;

        path.add(root.val);
        path_sum += root.val;

        //判断累积和是否存在符合点
        int size = path.size();

        int font_sum = 0;
        for (int i = 0; i < size; i++) {
            font_sum += (i == 0) ? 0 : path.get(i - 1);
            int rest = path_sum - font_sum;
            if (rest == target) count++;
        }

        helper(root.left, target);
        helper(root.right, target);
        path_sum -= root.val;
        path.remove(path.size() - 1);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(4);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.right = new TreeNode(1);

        Q437_path_sum_iii s = new Q437_path_sum_iii();
        int i = s.pathSum(root, 22);
        System.out.println(i);


    }
}
