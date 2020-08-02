package 区间问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q986_interval_list_intersections {
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        int i = 0, j = 0;
        List<int[]> result = new ArrayList<>();
        while (i < A.length && j < B.length) {
            int[] o1 = A[i], o2 = B[j];
            int[] cross = cross(o1, o2);
            if (cross != null) {
                result.add(cross);
            }
            if (o1[1] == o2[1]) {
                i++;
                j++;
            } else if (o1[1] < o2[1]) {
                i++;
            } else {
                j++;
            }
        }
        return result.toArray(new int[0][]);
    }

    private int[] cross(int[] A, int[] B) {
        int L = Math.max(A[0], B[0]);
        int R = Math.min(A[1], B[1]);
        if (L <= R) return new int[]{L, R};
        return null;
    }

    public static void main(String[] args) {
        Q986_interval_list_intersections s = new Q986_interval_list_intersections();
        int[][] A = {{0, 2}, {5, 10}, {13, 23}, {24, 25}}, B = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ints = s.intervalIntersection(A, B);
        for (int[] gap : ints) {
            System.out.println(Arrays.toString(gap));
        }
    }
}
