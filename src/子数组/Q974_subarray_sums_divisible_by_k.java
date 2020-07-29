package 子数组;

import java.util.HashMap;
import java.util.Map;

public class Q974_subarray_sums_divisible_by_k {
    public static int subarraysDivByK(int[] A, int K) {
        //dp+ 前缀和+ hash优化
        //dp[i]表示以i结尾的满足条件的子数组个数
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, count = 0;
        for (int num : A) {
            sum += num;
            sum = (sum % K + K) % K; //处理K为负数的时候
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.compute(sum, (k, v) -> v == null ? 1 : v + 1);
        }
        return count;
    }
}
