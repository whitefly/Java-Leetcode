package 哈希;

import java.util.HashMap;
import java.util.Map;

public class Q525_contiguous_array {
    public int findMaxLength(int[] nums) {
        /*
        思入1: 暴力法,得到每个位置从头开始1的个数,然后遍历所有组合,得到最高的那个
        时间复杂度: O(n^2) 空间复杂度:O(n)
         */

        int[] dp = new int[nums.length];
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = temp + (nums[i] == 1 ? 1 : 0);
            temp = dp[i];
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j += 2) {
                int count = dp[j] - (i == 0 ? 0 : dp[i - 1]);
                if (count * 2 == (j - i + 1)) {
                    result = Math.max(result, j - i + 1);
                }
            }
        }
        return result;
    }

    public int findMaxLength2(int[] nums) {
        /*
        思入: hash+状态机, 用1和0的数量差=len(1)-len(0)表示该点的状态,
        若2个点的状态相同,表示2个点经过的中间过程(不包含2个点),0和1的数量可以抵消.
        可以模仿2sum的方式,记录第一次处于该状态的点位置
         */
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int status = 0, result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) status--;
            else status++;

            if (map.containsKey(status)) {
                result = Math.max(result, i - map.get(status));
            } else map.put(status, i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] num = {0, 1, 0};
        Q525_contiguous_array s = new Q525_contiguous_array();
        System.out.println(s.findMaxLength2(num));
    }


}
