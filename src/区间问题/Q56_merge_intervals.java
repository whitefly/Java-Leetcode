package 区间问题;


import java.util.*;

public class Q56_merge_intervals {


    public static int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return intervals;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int L = intervals[0][0], R = intervals[0][1];
        for (int[] gap : intervals) {
            if (gap[0] <= R) {
                R = Math.max(R, gap[1]);
            } else {
                result.add(new int[]{L, R});
                L = gap[0];
                R = gap[1];
            }
        }
        result.add(new int[]{L, R});
        return result.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 4}, {2, 3}};
        int[][] ints = merge(nums);
        for (int[] gap : ints) {
            System.out.println(Arrays.toString(gap));
        }
    }
}
