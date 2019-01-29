package 树递归;

import java.util.ArrayList;
import java.util.List;

public class Q501_find_mode_in_binary_search_tree {
    List<Integer> result = new ArrayList<>();
    private int max_count = 0;
    private int last = Integer.MIN_VALUE;
    private int temp_count = 0;  //遍历某点时,临时的数量(可能没有遍历完)

    public int[] findMode(TreeNode root) {
        /**
         * 思入: 二叉搜索的中序遍历,问题转为 有序数组求众数问题(众数可能有多个).扫一遍,尽量少用额外空间
         * 设置一个最大count, 一旦遍历时,该数字的count等于最大, 则加入结果(可能此时该数字还没有遍历完).若超过count,则清空结果集,单独加入这个
         */
        helper(root);

        //
        int[] res = new int[result.size()];
        for (int i = 0; i < result.size(); ++i) res[i] = result.get(i);
        return res;

    }

    private void helper(TreeNode root) {
        if (root == null) return;

        helper(root.left);

        temp_count = (last == root.val) ? temp_count + 1 : 1;
        last = root.val;
        //更新结果集合 解决 等于和大于的情况
        if (temp_count == max_count) {
            result.add(root.val);
        } else if (max_count < temp_count) {
            result.clear();
            result.add(root.val);
            max_count = temp_count;
        }

        helper(root.right);

    }
}
