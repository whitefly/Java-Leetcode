package 动态规划;

public class Q45_jump_game_ii {
    public int jump(int[] nums) {
        /**
         * 思入: 动态规划.到该点所需要的step,思想有点类型与素数筛选.
         */
        int size = nums.length;
        if (size == 1) return 0;
        int[] dp = new int[size];
        int arrived = 0;
        for (int i = 0; i < size; i++) {
            int temp_arrive = nums[i] + i;
            if (arrived < temp_arrive) {
                int step = dp[i] + 1;
                if (size - 1 <= temp_arrive) return step;
                for (int j = arrived + 1; j <= temp_arrive; j++) dp[j] = step;
                arrived = temp_arrive;
            }
        }
        return 0;
    }


    public int jump2(int[] nums) {
        /**
         * 优化: 尝试减少空间复杂度减少为O(1),思想有点想 层次遍历
         */
        int size = nums.length;
        if (size == 1) return 0;

        int step = 0;
        int max_arrived = 0;
        int temp_arrived = 0;
        for (int index = 0; index < size; index++) {
            max_arrived = Math.max(index + nums[index], max_arrived);
            if (size - 1 <= max_arrived) return step + 1;

            if (index >= temp_arrived) {
                temp_arrived = max_arrived;
                step++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        Q45_jump_game_ii s = new Q45_jump_game_ii();
        int jump = s.jump2(nums);
        System.out.println(jump);
    }
}
