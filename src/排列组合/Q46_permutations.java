package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q46_permutations {
    List<List<Integer>> r = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    boolean gone[];


    public List<List<Integer>> permute(int[] nums) {
        /**
         * 思入: 深度搜索找到所有路径(回溯剪枝). 分支是还没有使用的数字(所以设置一个gone变量).
         */
        if (nums.length == 0) return r;
        gone = new boolean[nums.length];
        hepler(nums);
        return r;
    }

    private void hepler(int[] nums) {
        if (temp.size() == nums.length) {
            r.add((List<Integer>) temp.clone());
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (gone[i]) continue;
            gone[i] = true;
            temp.add(nums[i]);
            hepler(nums);
            gone[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q46_permutations s = new Q46_permutations();
        int[] nums = {};
        List<List<Integer>> permute = s.permute(nums);
        System.out.println(permute.toString());

    }


}
