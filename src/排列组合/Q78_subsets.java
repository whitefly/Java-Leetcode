package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q78_subsets {
    private List<List<Integer>> result = new ArrayList<>();
    private ArrayList<Integer> temp = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        /**
         * 思入:标准回溯剪枝 由于不能含有重复的.可以减少候选集的范围
         */
        result.add((List<Integer>) temp.clone());
        helper(nums, 0);
        return result;
    }

    private void helper(int[] nums, int begin) {
        if (temp.size() == nums.length) return;

        for (int i = begin; i < nums.length; i++) {
            temp.add(nums[i]);
            result.add((List<Integer>) temp.clone());
            helper(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Q78_subsets s = new Q78_subsets();
        List<List<Integer>> subsets = s.subsets(nums);
        for (List<Integer> one : subsets) System.out.println(one);
    }
}
