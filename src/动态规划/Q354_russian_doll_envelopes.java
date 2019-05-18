package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q354_russian_doll_envelopes {
    int[] dp;
    private List<List<Integer>> graph;

    public int maxEnvelopes(int[][] envelopes) {
        /**
         * 思入: DAG的最长路径(无初始点,末尾点可以).构建边关系
         */

        //排序
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] != o2[0]) return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        //构建图关系
        dp = new int[envelopes.length];
        Arrays.fill(dp, -1);
        graph = new ArrayList<>();
        for (int i = 0; i < envelopes.length; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < envelopes.length; i++) {
            for (int j = i+1; j < envelopes.length; j++) {
                if (lessThan(envelopes[i], envelopes[j])) graph.get(i).add(j);
            }
        }
        //DAG最长路径求解
        int result = 0;
        for (int i = 0; i < envelopes.length; i++) {
            result = Math.max(helper(i), result);
        }
        return result;
    }

    private int helper(int index) {
        if (dp[index] != -1) return dp[index];
        int result = 1;
        for (int next : graph.get(index)) {
            result = Math.max(helper(next) + 1, result);
        }
        return dp[index] = result;
    }

    private boolean lessThan(int[] a, int[] b) {
        return a[0] < b[0] && a[1] < b[1];
    }

    public static void main(String[] args) {
        int[][] envelopes = {{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        Q354_russian_doll_envelopes s = new Q354_russian_doll_envelopes();
        System.out.println(s.maxEnvelopes(envelopes));
    }
}
