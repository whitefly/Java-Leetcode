package 堆;

import java.util.*;

public class Q378_kth_smallest_element_in_a_sorted_matrix {

    public int kthSmallest(int[][] matrix, int k) {
        //二分,在确定一个坐标时,比他小的元素个数可以算出来. 根据count来.若恰好等于,则恰好就是那个数
        int i = matrix.length - 1, j = 0;
        int L = matrix[0][0], R = matrix[i][i];

        while (L < R) {
            int mid = (L + R) / 2;
            int count = check(matrix, mid);
            if (k <= count) {
                R = mid;
            } else {
                L = mid + 1;
            }
        }
        return L;
    }

    public int check(int[][] matrix, int mid) {
        int i = matrix.length - 1, j = 0;
        int limit = matrix[0].length;
        int count = 0;
        while (i >= 0 && j < limit) {
            if (matrix[i][j] <= mid) {
                count += i + 1;
                j++;
            } else {
                i--;
            }
        }
        return count;
    }


    static class Position {
        int x;
        int y;
        int value;

        public Position(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Position position = (Position) o;
            return x == position.x &&
                    y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

    public int kthSmallest2(int[][] matrix, int k) {
        //我的想法是类似拓扑排序+堆的想法,思如很容易,但是代码的实习有点多
        int limitX = matrix.length, limitY = matrix[0].length;
        Set<Position> set = new HashSet<>();
        PriorityQueue<Position> heap = new PriorityQueue<>(Comparator.comparingInt(o -> o.value));

        heap.add(new Position(0, 0, matrix[0][0]));
        for (int i = 0; i < k - 1; i++) {
            final Position poll = heap.poll();
            Position down = ((poll.x + 1) < limitX) ? new Position(poll.x + 1, poll.y, matrix[poll.x + 1][poll.y]) : null;
            Position right = ((poll.y + 1) < limitX) ? new Position(poll.x, poll.y + 1, matrix[poll.x][poll.y + 1]) : null;

            if (down != null && !set.contains(down)) {
                set.add(down);
                heap.add(down);
            }
            if (right != null && !set.contains(right)) {
                set.add(right);
                heap.add(right);
            }
        }
        return heap.poll().value;
    }


    public static void main(String[] args) {
        final Q378_kth_smallest_element_in_a_sorted_matrix s = new Q378_kth_smallest_element_in_a_sorted_matrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        final int i = s.kthSmallest(matrix, k);
        System.out.println(i);

    }
}
