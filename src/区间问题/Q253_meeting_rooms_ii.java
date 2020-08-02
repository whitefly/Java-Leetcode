package 区间问题;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q253_meeting_rooms_ii {
    static class Node {
        int t;
        boolean in;

        public Node(int t, boolean in) {
            this.t = t;
            this.in = in;
        }
    }

    public int minMeetingRooms(int[][] intervals) {
        //只需要关注每个时间点即可,2n个时间点排序
        List<Node> nodes = new ArrayList<>();
        for (int[] gap : intervals) {
            nodes.add(new Node(gap[0], true));
            nodes.add(new Node(gap[1], false));
        }
        Collections.sort(nodes, (o1, o2) -> o1.t != o2.t ? o1.t - o2.t : o1.in ? 1 : -1);
        int result = 0, count = 0;
        for (Node node : nodes) {
            int useless = node.in ? count++ : count--;
            result = Math.max(result, count);
        }
        return result;
    }
}
