package 动态规划;

public class Q55_jump_game {
    public boolean canJump(int[] nums) {
        /**
         * 思入: 筛选法. 走到该步死,将未来所有可能的点都标记为true
         */
        int size = nums.length;
        boolean[] gone = new boolean[size];
        gone[0] = true;
        for (int i = 0; i < size; i++) {
            if (!gone[i]) continue;
            int range = nums[i];
            for (int j = 1; j <= range; j++) if (j + i < size) gone[j + i] = true;
        }
        return gone[size - 1];
    }

    public static void main(String[] args) {
        Q55_jump_game s = new Q55_jump_game();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(s.canJump(nums));
    }
}
