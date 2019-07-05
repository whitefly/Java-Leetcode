package 树递归;

import java.util.*;

public class Q508_most_frequent_subtree_sum {
    private Map<Integer, Integer> counter = new HashMap<>();
    private int maxSize = 0;
    List<Integer> result = new ArrayList<>();

    public int[] findFrequentTreeSum(TreeNode root) {
        /**
         * 思入: 返回子树和,用一个全局map记录频率,并有一个maxSize记录动态记录最大的频率
         */
        if (root == null) return new int[0];
        helper(root);
        int[] rnt = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            rnt[i] = result.get(i);
        }
        return rnt;

    }

    private int helper(TreeNode root) {
        int sum = root.val;

        if (root.left != null) sum += helper(root.left);
        if (root.right != null) sum += helper(root.right);

        if (!counter.containsKey(sum)) counter.put(sum, 0);
        int count = counter.get(sum);
        count++;

        if (maxSize < count) result.clear();
        if (maxSize <= count) {
            result.add(sum);
            maxSize=count;
        }
        counter.put(sum, count);
        return sum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Q508_most_frequent_subtree_sum s = new Q508_most_frequent_subtree_sum();
        int[] result = s.findFrequentTreeSum(root);
        System.out.println(Arrays.toString(result));
    }
}
