package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q47_permutations_ii {
    List<List<Integer>> r = new ArrayList<>();
    ArrayList<Integer> temp = new ArrayList<>();
    boolean gone[];

    public List<List<Integer>> permuteUnique(int[] nums) {
        /**
         * 思入: 深度搜索找到所有路径(回溯剪枝). 分支是还没有使用的数字(所以设置一个gone变量). 由于不能重复,所以创建子分支时,跳过重复的
         */
        if (nums.length == 0) return r;
        gone = new boolean[nums.length];
        Arrays.sort(nums);
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
            if (i != 0 && !gone[i - 1] && nums[i - 1] == nums[i]) continue;
            gone[i] = true;
            temp.add(nums[i]);
            hepler(nums);
            gone[i] = false;
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q47_permutations_ii s = new Q47_permutations_ii();
        int[] nums = {3, 3, 0, 3};
        List<List<Integer>> lists = s.permuteUnique(nums);
        System.out.println(lists.toString());
    }
}
