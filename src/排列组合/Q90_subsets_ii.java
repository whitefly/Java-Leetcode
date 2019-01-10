package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q90_subsets_ii {
    List<List<Integer>> result = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    boolean[] gone;
    int size;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        /**
         * 思入: 回溯剪枝. 每次路径长一点,就记录一次. 不允许使用元素
         */
        size = nums.length;
        if (size == 0) return result;
        Arrays.sort(nums);
        gone = new boolean[size];
        helper(nums, 0, size);
        return result;
    }

    private void helper(int nums[], int l, int r) {
        result.add((List<Integer>) temp.clone());
        if (temp.size() == size) return;

        for (int i = l; i < r; i++) {
            if (gone[i]) continue;
            if (i != 0 && !gone[i - 1] && nums[i - 1] == nums[i]) continue;
            temp.add(nums[i]);
            gone[i] = true;
            helper(nums, i + 1, r);
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
