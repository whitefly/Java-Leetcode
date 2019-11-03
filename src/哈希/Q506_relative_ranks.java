package 哈希;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Q506_relative_ranks {
    private static String RANK1 = "Gold Medal";
    private static String RANK2 = "Silver Medal";
    private static String RANK3 = "Bronze Medal";

    public String[] findRelativeRanks(int[] nums) {
        /*
        思入: 使用一个tree_map做映射.  value:原始下标
         */
        Map<Integer, Integer> map = new TreeMap<>((o1, o2) -> o2-o1);
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        String[] result = new String[nums.length];
        int count = 0;
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            count++;
            if (count == 1) {
                result[item.getValue()] = RANK1;
            } else if (count == 2) {
                result[item.getValue()] = RANK2;
            } else if (count == 3) {
                result[item.getValue()] = RANK3;
            } else {
                result[item.getValue()] = "" + count;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        Q506_relative_ranks s = new Q506_relative_ranks();
        System.out.println(Arrays.toString(s.findRelativeRanks(nums)));
    }

}
