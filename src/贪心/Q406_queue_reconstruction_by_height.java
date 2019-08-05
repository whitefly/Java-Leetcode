package 贪心;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Q406_queue_reconstruction_by_height {
    /*
   思入: 从大到小,然后从大到小遍历, 后缀是i,就在第i位插入
    */
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (o1, o2) -> {
            if (o2[0] == o1[0]) return o1[1] - o2[1];
            return o2[0] - o1[0];
        });
        List<int[]> container = new LinkedList<>();
        for (int[] item : people) container.add(item[1], item);
        return container.toArray(new int[0][0]);
    }

    public static void main(String[] args) {
        int[][] nums = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        Q406_queue_reconstruction_by_height s = new Q406_queue_reconstruction_by_height();
        int[][] ints = s.reconstructQueue(nums);

        for (int[] item : ints) {
            System.out.println(Arrays.toString(item));
        }
    }
}
