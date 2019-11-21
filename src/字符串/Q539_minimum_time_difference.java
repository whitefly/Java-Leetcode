package 字符串;

import java.util.Arrays;
import java.util.List;

public class Q539_minimum_time_difference {
    public int findMinDifference(List<String> timePoints) {
        /*
        思入: 转换成时间戳,然后排序,2个相邻之间比较
         */
        int len = timePoints.size();
        int[] times = new int[len + 1];
        for (int i = 0; i < len; i++) {
            times[i] = strToMinute(timePoints.get(i));
        }
        Arrays.sort(times, 0, len);
        times[len] = times[0] + 1440;
        int rnt = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            rnt = Math.min(times[i + 1] - times[i], rnt);
        }
        return rnt;
    }

    private int strToMinute(String str) {
        String[] split = str.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    public static void main(String[] args) {
        String[] demo = {"23:59", "00:00"};
        Q539_minimum_time_difference s = new Q539_minimum_time_difference();
        int minDifference = s.findMinDifference(Arrays.asList(demo));
        System.out.println(minDifference);
    }


}
