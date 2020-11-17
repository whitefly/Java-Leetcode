package 图论;

import java.util.*;

public class Q1030_matrix_cells_in_distance_order {
    static int[][] changes = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    static class Position {
        int x;
        int y;
        int dis;

        public Position(int x, int y, int dis) {
            this.x = x;
            this.y = y;
            this.dis = dis;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        //广度遍历done
        Queue<Position> Q = new LinkedList<>();
        Set<Position> gone = new HashSet<>();
        Position temp = new Position(r0, c0, 0);
        Q.offer(temp);
        gone.add(temp);
        int[][] result = new int[R * C][];
        int index = 0;
        while (!Q.isEmpty()) {
            Position start = Q.poll();
            result[index++] = new int[]{start.x, start.y};
            for (int[] change : changes) {
                int nextX = start.x + change[0];
                int nextY = start.y + change[1];
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                Position next = new Position(nextX, nextY, start.dis + 1);
                if (!gone.contains(next)) {
                    Q.offer(next);
                    gone.add(next);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int R = 2, C = 3, r0 = 1, c0 = 2;
        Q1030_matrix_cells_in_distance_order solver = new Q1030_matrix_cells_in_distance_order();
        int[][] ints = solver.allCellsDistOrder(R, C, r0, c0);
        Arrays.stream(ints).forEach(x -> System.out.println(Arrays.toString(x)));
    }
}
