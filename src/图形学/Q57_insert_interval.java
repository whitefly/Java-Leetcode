package 图形学;


import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return String.format("%d-%d", start, end);
    }
}

public class Q57_insert_interval {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        /**
         * 思入:在数组上进行修改的思想,二分搜索找到正确插入点,然后调用merge来合并
         */
        int index = bin_search(intervals, newInterval.start);
        intervals.add(index + 1, newInterval);
        return merge(intervals);
    }

    private List<Interval> merge(List<Interval> intervals) {
        /**
         * 思入: 先排序,遍历list, 前后比较,若后的start在前一个的区间中,修改前一个end值,并删除后一个
         */
        if (intervals.size() == 0) return intervals;
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

    private int bin_search(List<Interval> intervals, int val) {
        int l = 0, r = intervals.size() - 1;
        if (l > r) return -1;
        while (l + 1 < r) {
            int mid = (l + r) / 2;
            Interval temp = intervals.get(mid);
            if (val < temp.start) r = mid - 1;
            if (temp.start <= val) l = mid;
        }
        //剩下2个
        Interval temp = intervals.get(r);
        if (temp.start <= val) return r;
        temp = intervals.get(l);
        if (temp.start <= val) return l;
        return l - 1;
    }

    public static void main(String[] args) {
        Q57_insert_interval s = new Q57_insert_interval();
        ArrayList<Interval> intervals = new ArrayList<>();
//        int[][] nums = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
//        for (int[] num : nums) {
//            intervals.add(new Interval(num[0], num[1]));
//        }

        Interval one = new Interval(5, 7);
        List<Interval> insert = s.insert(intervals, one);
        System.out.println(insert);
    }


}
