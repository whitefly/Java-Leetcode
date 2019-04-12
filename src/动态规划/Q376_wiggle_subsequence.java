package 动态规划;

import java.util.Map;

public class Q376_wiggle_subsequence {
    public int wiggleMaxLength(int[] nums) {
        /**
         * 动态规划: 出现连续递增的数,直接跳过,找到连续树中最高的那个即可.
         * 考虑2种波形
         */
        if (nums.length <= 1) return nums.length;
        //最低-->最高--->最低 或者 最高->最低->最高
        return Math.max(helper(nums, true), helper(nums, false));
    }

    public int helper(int[] nums, boolean flag) {
        int last = flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int maxIndex = nums.length - 1;
        int result = 0;
        for (int i = 0; i <= maxIndex; i++) {
            if (last == nums[i]) continue;
            if (flag) {
                if (i == maxIndex || nums[i] > nums[i + 1]) {
                    result++;
                    last = nums[i];
                    flag = false;
                }
            } else {
                if (i == maxIndex || nums[i] < nums[i + 1]) {
                    result++;
                    last = nums[i];
                    flag = true;
                }
            }

        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3, 3, 3, 2, 5};
        Q376_wiggle_subsequence s = new Q376_wiggle_subsequence();
        System.out.println(s.wiggleMaxLength(nums));
    }
}
