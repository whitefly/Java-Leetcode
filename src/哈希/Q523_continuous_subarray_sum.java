package 哈希;

import java.util.HashMap;
import java.util.Map;

public class Q523_continuous_subarray_sum {
    public boolean checkSubarraySum(int[] nums, int k) {
        /*
        思入: 暴力法, 扫遍所有的组合
         */
        int[] sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
        }
        //暴力所有的组合
        int sum;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                sum = sums[j] - sums[i] + nums[i];
                if (k == 0) {
                    if (sum == 0) return true;
                } else {
                    if (sum % k == 0) return true;
                }

            }
        }
        return false;
    }

    public boolean checkSubarraySum2(int[] nums, int k) {
        /*
        思入: 使用hash来记录,累计和%k
        一旦出现2次出现相同的状态,则中间变化即为所求
        (rnt+n*k)%k=rnt
         */
        int[] sums = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0, last = 0; i < nums.length; i++) {
            sums[i] = last + nums[i];
            int target = (k != 0) ? sums[i] % k : sums[i];
            if (map.containsKey(target)) {
                if (i - map.get(target) > 1) return true;
            } else {
                map.put(target, i);
            }
            last = sums[i];
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {23, 2, 4, 6, 7};
        int k = 6;
        Q523_continuous_subarray_sum s = new Q523_continuous_subarray_sum();
        boolean b = s.checkSubarraySum2(nums, k);
        System.out.println(b);

    }
}
