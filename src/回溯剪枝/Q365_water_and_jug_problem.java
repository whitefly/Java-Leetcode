package 回溯剪枝;

import java.util.*;

public class Q365_water_and_jug_problem {
    private class Status {
        int x;
        int y;

        private Status(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Status status = (Status) o;
            return x == status.x &&
                    y == status.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        @Override
        public String toString() {
            return x + "-" + y;
        }
    }

    private Map<Status, Boolean> gone = new HashMap<>();
    private Map<Status, Status> process = new HashMap<>(); //用来记录结果,还原过程
    private Status target;

    /**
     * 思入: 深度优先遍历所有的状态(x,y的状态),然后判断是否含有z.
     * 发现直接溢出.所以采用BFS
     */
    private boolean canMeasureWater(int x, int y, int z) {
        Queue<Status> Q = new LinkedList<>();
        Status s = new Status(0, 0);
        process.put(s, null);
        Q.offer(s);
        gone.put(s, true);
        while (!Q.isEmpty()) {
            Status temp = Q.poll();
            int temp_x = temp.x;
            int temp_y = temp.y;
            if (temp_x == z || temp_y == z || temp_x + temp_y == z) {
                target = temp;
                return true;
            }
            Status new_s;
            //装满某个水壶
            if ((new_s = isGoneOrAdd(x, temp_y)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
            if ((new_s = isGoneOrAdd(temp_x, y)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
            //清空某个壶
            if ((new_s = isGoneOrAdd(0, temp_y)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
            if ((new_s = isGoneOrAdd(temp_x, 0)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
            //A->B
            if (y - temp_y <= temp_x) {
                if ((new_s = isGoneOrAdd(temp_x - (y - temp_y), y)) != null) {
                    process.put(new_s, temp);
                    Q.offer(new_s);
                }
            } else if ((new_s = isGoneOrAdd(0, temp_x + temp_y)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
            //A<-B
            if (x - temp_x <= temp_y) {
                if ((new_s = isGoneOrAdd(x, temp_y - (x - temp_x))) != null) {
                    process.put(new_s, temp);
                    Q.offer(new_s);
                }
            } else if ((new_s = isGoneOrAdd(temp_x + temp_y, 0)) != null) {
                process.put(new_s, temp);
                Q.offer(new_s);
            }
        }

        return false;
    }

    private Status isGoneOrAdd(int x, int y) {
        Status s = new Status(x, y);
        if (gone.containsKey(s)) return null;
        gone.put(s, true);
        return s;
    }


    public static void main(String[] args) {
        int x = 22003, y = 31237, z = 123;
//        int x = 3, y = 5, z = 4;
        Q365_water_and_jug_problem s = new Q365_water_and_jug_problem();
        boolean b = s.canMeasureWater(x, y, z);
        if (b) {
            //逆过去
            Status begin = s.target;
            do {
                System.out.println(begin);
                begin = s.process.get(begin);
            } while (begin != null);
        }
    }
}
