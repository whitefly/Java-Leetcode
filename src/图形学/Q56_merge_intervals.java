package 图形学;

import java.util.*;

public class Q56_merge_intervals {
    public List<Interval> merge(List<Interval> intervals) {
        /**
         * 思入(原地): 先排序,遍历list, 前后比较,若后的start在前一个的区间中,修改前一个end值,并删除后一个
         */
        if (intervals.size() == 0) return intervals;
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        //遍历,在原list上进行合并删除节点
        Interval last = intervals.get(0);
        Iterator<Interval> iterator = intervals.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            Interval temp = iterator.next();
            if (last.start <= temp.start && temp.start <= last.end) {
                last.end = Math.max(last.end, temp.end);  // 解决 (2,10),(3,5)的情况
                iterator.remove();  //
            } else last = temp;
        }

        return intervals;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        /**
         * 思入(新建): 排序,遍历增加,若碰到一个,它的start在最后一个的范围内,则更新最后一个的end
         */
        List<Interval> result = new ArrayList<>();
        int size = intervals.size();
        if (size == 0) return result;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        //遍历增加
        result.add(intervals.get(0));
        for (int i = 1; i < size; i++) {
            Interval last = result.get(result.size() - 1);
            Interval temp = intervals.get(i);

            if (last.start <= temp.start && temp.start <= last.end) last.end = Math.max(last.end, temp.end);
            else result.add(temp);
        }
        return result;
    }

    public static void main(String[] args) {
        Q56_merge_intervals s = new Q56_merge_intervals();
        ArrayList<Interval> intervals = new ArrayList<>();
        int[][] nums = {{1, 4}, {0, 2}, {3, 5}};
        for (int[] num : nums) {
            intervals.add(new Interval(num[0], num[1]));
        }
        List<Interval> r = s.merge2(intervals);
        System.out.println(r);

    }
}
