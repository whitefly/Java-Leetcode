package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q77_combinations {
    ArrayList<Integer> temp = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        /**
         * 思入:简单的回溯剪枝
         */
        helper(n, k, 1);
        return result;
    }

    private void helper(int n, int k, int index) {
        if (temp.size() == k) {
            result.add((List<Integer>) temp.clone());
            return;
        }

        for (int i = index; i <= n; i++) {
            temp.add(i);
            helper(n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        int n = 4;
        int k = 2;
        Q77_combinations s = new Q77_combinations();
        List<List<Integer>> combine = s.combine(n, k);
        System.out.println(combine);
    }

}
