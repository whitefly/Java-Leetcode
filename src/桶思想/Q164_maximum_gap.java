package 桶思想;

import java.util.Arrays;

public class Q164_maximum_gap {
    public int maximumGap(int[] nums) {
        //确定每个桶可以存放整数的范围
        if (nums.length < 2) return 0;
        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int d = Math.max(1, (max - min) / (nums.length - 1));
        int bucketSize = (max - min) / d + 1;
        //构造n个桶
        int[][] buckets = new int[bucketSize][2];
        for (int[] item : buckets) Arrays.fill(item, -1);

        //分配
        int[] bucket;
        for (int num : nums) {
            int bucketId = (num - min) / d;
            bucket = buckets[bucketId];
            if (bucket[0] == -1) {
                bucket[0] = bucket[1] = num;
            } else {
                bucket[0] = Math.min(bucket[0], num);
                bucket[1] = Math.max(bucket[1], num);
            }
        }

        //比较前一个桶的最大和后一个桶的最小,若某个桶不一样,则跨桶比较
        int result = 0;
        int prev = -1;
        for (int i = 0; i < bucketSize; i++) {
            if (buckets[i][0] == -1) continue;
            if (prev != -1) {
                result = Math.max(result, buckets[i][0] - buckets[prev][1]);
            }
            prev = i;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 100};
        Q164_maximum_gap solution = new Q164_maximum_gap();
        int i = solution.maximumGap(nums);
        System.out.println(i);
    }
}
