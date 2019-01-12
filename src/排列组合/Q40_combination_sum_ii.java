package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q40_combination_sum_ii {
    private ArrayList<Integer> temp = new ArrayList<>();
    private List<List<Integer>> r = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, 0, target, 0);
        return r;
    }

    private void helper(int[] candidates, int index, int target, int sum) {
        if (target < sum) return;
        if (target == sum) r.add((List<Integer>) temp.clone());

        for (int i = index; i < candidates.length; i++) {
            //平行时,不允许使用重复数
            if (i > index && candidates[i - 1] == candidates[i]) continue;
            int num = candidates[i];
            temp.add(num);
            helper(candidates, i + 1, target, sum + num);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        Q40_combination_sum_ii s = new Q40_combination_sum_ii();
        List<List<Integer>> lists = s.combinationSum2(nums, 8);
        System.out.println(lists);
    }
}
