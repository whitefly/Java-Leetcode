package 子数组;

import java.util.HashMap;
import java.util.Map;

public class Q560_subarray_sum_equals_k {
    public int subarraySum(int[] nums, int k) {
        //dp+推理+前缀和
        //dp[i]表示以i结尾所有和k的子数组个数
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, result = 0;
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if (map.containsKey(sum - k)) result += map.get(sum - k);
            map.compute(sum, (K, V) -> (V == null) ? 1 : V + 1);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
