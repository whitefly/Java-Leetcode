package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90_subsets_ii {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    boolean[] gone;
    int[] nums;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
         * 思入: 回溯剪枝. 每次路径长一点,就记录一次. 不允许使用元素
         */
        this.nums = nums;
        Arrays.sort(nums);
        gone = new boolean[nums.length];
        helper(0);
        return result;
    }

    private void helper(int n) {
        result.add((List<Integer>) temp.clone());
        if (temp.size() == nums.length) return;

        for (int i = n; i < nums.length; i++) {
            if (i != n && nums[i - 1] == nums[i]) continue;
            if (gone[i]) continue;
            temp.add(nums[i]);
            gone[i] = true;
            helper(i + 1);
            temp.remove(temp.size() - 1);
            gone[i] = false;
        }
    }

    public static void main(String[] args) {
        Q90_subsets_ii s = new Q90_subsets_ii();
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = s.subsetsWithDup(nums);
        System.out.println(lists);
    }
}
