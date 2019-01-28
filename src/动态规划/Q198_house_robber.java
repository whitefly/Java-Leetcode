package 动态规划;

import java.util.Arrays;

public class Q198_house_robber {
    public int rob(int[] nums) {
        /**
         * 思入: 动态规划:  到i点为止(包含该点),所偷到的最大的金额. 需要扫0-i-2点所有的位置,找一个最大的跟在后面
         * 可以简化计算,
         */
        int size = nums.length;
        if (size == 0) return 0;
        if (size == 1) return nums[0];
        if (size == 2) return Math.max(nums[0], nums[1]);

        int result = Math.max(nums[0], nums[1]);
        int max_gap2 = nums[0];
        int last = nums[1];
        for (int i = 2; i < size; i++) {
            int temp = max_gap2 + nums[i];
            result = Math.max(result, temp);
            //更新
            max_gap2 = Math.max(max_gap2, last);
            last = temp;
        }
        return result;

    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        Q198_house_robber s = new Q198_house_robber();
        int rob = s.rob(nums);
        System.out.println(rob);
    }
}
