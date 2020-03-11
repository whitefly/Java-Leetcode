package 二分;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Q729_my_calendar_i {
    static class Interval {
        public int start;
        public int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static class MyCalendar {

        List<Interval> container;

        public MyCalendar() {
            container = new LinkedList<>();
            container.add(new Interval(-1, 0));
            container.add(new Interval(Integer.MAX_VALUE - 1, Integer.MAX_VALUE));
        }

        public boolean book(int start, int end) {
            //暴力遍历法
            int size = container.size() - 1;
            for (int i = 0; i < size; i++) {
                Interval left = container.get(i);
                Interval right = container.get(i + 1);
                if (left.end <= start && end <= right.start) {
                    container.add(i + 1, new Interval(start, end));
                    return true;
                }
            }
            return false;
        }
    }

    static class MyCalendar2 {
        TreeMap<Integer, Integer> map;

        public MyCalendar2() {
            map = new TreeMap<>();
        }

        public boolean book(int start, int end) {
            //treeMap的二分法
            Map.Entry<Integer, Integer> entry1 = map.floorEntry(start);//小于start第一个键
            Map.Entry<Integer, Integer> entry2 = map.ceilingEntry(start); //大于start第一个键
            if ((entry1 == null || entry1.getValue() <= start) && (entry2 == null || end <= entry2.getKey())) {
                map.put(start, end);
                return true;
            }
            return false;
        }
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20)); // returns true
        System.out.println(myCalendar.book(15, 25)); // returns false
        System.out.println(myCalendar.book(20, 30)); // returns true

        int x = 0x7fffffff;
        x += 2L;
        System.out.println(x);
    }
}
