package 子序列;

import java.util.Arrays;

public class Q354_russian_doll_envelopes {
    public int maxEnvelopes(int[][] envelopes) {
        //排序+最长子序列
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);

        //对维度二的数组进行最长子序列搜索
        int[] widths = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) widths[i] = envelopes[i][1];
        return helper(widths);
    }

    private int helper(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLen = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp, 0, maxLen, num);
            if (i < 0) i = -i - 1;
            if (i == maxLen) maxLen++;
            dp[i] = num;
        }
        return maxLen;
    }
}
