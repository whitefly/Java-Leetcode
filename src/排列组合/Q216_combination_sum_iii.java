package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q216_combination_sum_iii {
    List<List<Integer>> r = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        /**
         * 思入: 回溯剪枝,长为k时,终止.由于每个数字只用一次,且没有重复数字.所以不断缩小可选数字范围.
         */
        helper(k, n, 1, 0);
        return r;
    }

    private void helper(int k, int n, int index, int sum) {
        if (temp.size() == k) {
            if (sum == n) r.add((List) temp.clone());
            return;
        }
        for (int i = index; i <= 9; i++) {
            temp.add(i);
            helper(k, n, i + 1, sum + i);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q216_combination_sum_iii s = new Q216_combination_sum_iii();
        List<List<Integer>> lists = s.combinationSum3(3, 7);
        System.out.println(lists);
    }


}
