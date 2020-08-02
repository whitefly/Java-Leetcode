package 区间问题;

import java.util.Arrays;
import java.util.Comparator;

public class Q435_non_overlapping_intervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        /*
        思入:贪心
        当2个区间有重叠时,丢失掉end较大的那个
         */
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        int[] last = {Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count = 0;
        for (int[] gap : intervals) {
            if (last[1] <= gap[0]) {
                last = gap;
                continue;
            }

            if (gap[1] <= last[1]) last = gap;
            count++;

        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
//        int[][] nums = {{1, 2}, {1, 2}, {1, 2}};
        int[][] nums = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        // (1,100),(1,11),(2,12),11,22)
        Q435_non_overlapping_intervals s = new Q435_non_overlapping_intervals();
        System.out.println(s.eraseOverlapIntervals(nums));

    }
}
