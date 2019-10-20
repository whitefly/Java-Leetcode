package 双指针;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Q5089_meeting_scheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Arrays.sort(slots1, Comparator.comparingInt(o -> o[0]));
        Arrays.sort(slots2, Comparator.comparingInt(o -> o[0]));

        for (int i = 0, j = 0, temp; i < slots1.length && j < slots2.length; ) {
            int[] gap1 = slots1[i], gap2 = slots2[j];
            int[] across = getAcross(gap1, gap2);
            if (across != null && across[1] - across[0] >= duration) {
                return Arrays.asList(across[0], across[0] + duration);
            }
            temp = gap1[1] < gap2[1] ? i++ : j++; //无重叠或者不符合
        }
        return new ArrayList<>();
    }

    private int[] getAcross(int[] gap1, int[] gap2) {
        //找到2个区间的重叠区域
        int begin = Math.max(gap1[0], gap2[0]);
        int end = Math.min(gap1[1], gap2[1]);
        if (begin < end) return new int[]{begin, end};
        else return null;
    }

    public static void main(String[] args) {
//        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {60, 70}};
        // int duration = 8;
//        int[][] slots1 = {{10, 50}, {60, 120}, {140, 210}}, slots2 = {{0, 15}, {60, 70}};
//        int duration = 12;
        int[][] slots1 = {{0, 2}}, slots2 = {{1, 3}};
        int duration = 2;
        Q5089_meeting_scheduler s = new Q5089_meeting_scheduler();
        List<Integer> result = s.minAvailableDuration(slots1, slots2, duration);
        System.out.println(result);

    }
}
