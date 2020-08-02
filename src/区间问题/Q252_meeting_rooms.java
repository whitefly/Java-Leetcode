package 区间问题;

import java.util.Arrays;
import java.util.Comparator;

public class Q252_meeting_rooms {
    public boolean canAttendMeetings(int[][] intervals) {
        //排序,扫一遍判断是否重叠
        if (intervals == null || intervals.length <= 1) return true;
        Arrays.sort(intervals, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (cross(prev, intervals[i])) {
                return false;
            }
            prev = intervals[i];
        }
        return true;
    }

    private boolean cross(int[] A, int[] B) {
        int L = Math.max(A[0], B[0]);
        int R = Math.min(A[1], B[1]);
        return L < R;
    }

}
