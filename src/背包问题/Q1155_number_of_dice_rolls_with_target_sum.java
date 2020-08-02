package 背包问题;

public class Q1155_number_of_dice_rolls_with_target_sum {
    public static int numRollsToTarget(int d, int f, int target) {
        //分组背包 dp[k][v]表示 使用完k个色子,点数和为v的组合数
        if (target < d || target > d * f) return 0;
        int[] dp = new int[target + 1];
        for (int i = 1; i <= f && i <= target; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < d; i++) {
            //每个色子
            for (int j = target; j >= 1; j--) {
                //对于每个target,选出最优的
                dp[j] = 0;
                for (int k = 1; k <= f; k++) {
                    if (j - k >= 1) {
                        dp[j] += dp[j - k];
                        dp[j] %= 1000000007;
                    }
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int d = 30, f = 30, target = 500;
        int i = numRollsToTarget(d, f, target);
        System.out.println(i);
    }
}
