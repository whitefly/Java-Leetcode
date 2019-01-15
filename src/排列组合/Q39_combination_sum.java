package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q39_combination_sum {
    private ArrayList<Integer> temp = new ArrayList<>();
    private List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        /**
         * 思入: 回溯剪枝,超过target时终止
         */
        helper(candidates, 0, target, 0);
        return r;

    }

    private void helper(int[] candidates, int index, int target, int sum) {
        if (target <= sum) {
            if (target == sum) r.add((List<Integer>) temp.clone());
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int num = candidates[i];
            temp.add(num);
            helper(candidates, i, target, sum + num);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5};
        Q39_combination_sum s = new Q39_combination_sum();
        List<List<Integer>> lists = s.combinationSum(nums, 8);
        System.out.println(lists);
    }
}
