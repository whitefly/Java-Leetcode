package 动态规划;

public class Q55_jump_game {
    public boolean canJump(int[] nums) {
        /**
         * 思入: 筛选法. 走到该步时,将未来所有可能的点都标记为true
         */
        int size = nums.length;
        boolean[] gone = new boolean[size];
        gone[0] = true;
        for (int i = 0; i < size; i++) {
            if (!gone[i]) return false;
            int range = nums[i];
            for (int j = 1; j <= range; j++) if (j + i < size) gone[j + i] = true;
            if (gone[size - 1]) return true;
        }
        return gone[size - 1];
    }


    public boolean canJump2(int[] nums) {
        /**
         * 思入2: 得到最大的落脚点
         */
        int remote = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (remote < i) return false;
            remote = Math.max(remote, i + nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        Q55_jump_game s = new Q55_jump_game();
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(s.canJump2(nums));
    }
}
