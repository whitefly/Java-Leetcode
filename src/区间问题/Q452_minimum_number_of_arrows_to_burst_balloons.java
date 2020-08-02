package 区间问题;

import java.util.Arrays;
import java.util.Comparator;

public class Q452_minimum_number_of_arrows_to_burst_balloons {
    public static int findMinArrowShots(int[][] points) {
        //排序+贪心
        //一支箭尽可能多射
        if (points == null || points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int R = Integer.MAX_VALUE, result = 1;
        for (int[] gap : points) {
            if (gap[0] <= R) {
                R = Math.min(gap[1], R);
            } else {
                result++;
                R = gap[1];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] nums = {{10, 16}, {2, 8}, {1, 6}, {7, 12}};
        int minArrowShots = findMinArrowShots(nums);
        System.out.println(minArrowShots);

    }
}
