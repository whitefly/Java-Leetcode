package 哈希;

import java.util.HashMap;
import java.util.Map;

public class Q128_longest_consecutive_sequence {
    public int longestConsecutive(int[] nums) {
        /**
         * 思入: 通过hash来记录 以xx为边界的最大的长度值. 然后每新进一个节点,开始更新自己和边界
         */
        Map<Integer, Integer> hash = new HashMap<>();
        int result = 0;
        for (int num : nums) {
            if (hash.containsKey(num)) continue;
            //开始寻找左边邻居结果值 和 右边邻居结果值
            int l = hash.getOrDefault(num - 1, 0);
            int r = hash.getOrDefault(num + 1, 0);
            int size;
            if (l > 0 && r > 0) {
                //左右邻居都存在,更新左右边界
                size = l + r + 1;
                hash.put(num - l, size);
                hash.put(num + r, size);
            } else if (l > 0) {
                //左邻居存在
                size = l + 1;
                hash.put(num - l, size);
            } else if (r > 0) {
                //右邻居存在
                size = r + 1;
                hash.put(num + r, size);
            } else {
                //左右邻居都不存在
                size = 1;
            }
            hash.put(num, size);
            result = Math.max(result, size);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        Q128_longest_consecutive_sequence s = new Q128_longest_consecutive_sequence();
        int i = s.longestConsecutive(nums);
        System.out.println(i);
    }
}
