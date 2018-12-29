package 动态规划;

import java.util.List;

public class Q120_triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * 思入: 动态规划思想,直接在原数组中存储dp
         */
        if (triangle.size() == 1) return triangle.get(0).get(0);
        int size = triangle.size() - 1;
        List<Integer> last_row, row = null;

        for (int i = 1; i <= size; i++) {
            last_row = triangle.get(i - 1);
            row = triangle.get(i);
            int size2 = row.size() - 1;

            for (int j = 0; j <= size2; j++) {
                int num = row.get(j);
                int up_l = (j == 0) ? Integer.MAX_VALUE : last_row.get(j - 1);
                int up_r = (j == size2) ? Integer.MAX_VALUE : last_row.get(j);

                row.set(j, num + Math.min(up_l, up_r));  //核心
            }
        }

        //扫最后一排
        int r = Integer.MAX_VALUE;
        for (int x : row) r = Math.min(r, x);
        return r;
    }
}
