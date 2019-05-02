package 动态规划;

import java.util.*;

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

    /**
     * 思入: 动态规划法,额外添加打印出最优解的路径(使用Map来记录 子-->父 )
     * dp[i][j]=nums[i][j]+max(dp[i-1][j-1],dp[i-1][j])
     * 上一层得出dp结果后,就可以得出下一层的dp
     **/
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        Map<String, String> path = new HashMap<>();
        path.put("1-0", "0-0");
        path.put("1-1", "0-0");
        path.put("0-0", null);
        int m = triangle.size(), n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            int thisRowSize = triangle.get(i).size();
            for (int j = 0; j < thisRowSize; j++) {
                int num = triangle.get(i).get(j);
                int up_l = (j == 0) ? Integer.MAX_VALUE : dp[i - 1][j - 1];
                int up_r = (j == (thisRowSize - 1)) ? Integer.MAX_VALUE : dp[i - 1][j];
                dp[i][j] = num + Math.min(up_l, up_r);

                path.put(String.format("%d-%d", i, j), String.format("%d-%d", i - 1, up_l < up_r ? j - 1 : j));
            }
        }
        String leaf = null;
        int value = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            int x = dp[m - 1][j];
            if (x < value) {
                value = x;
                leaf = String.format("%d-%d", m - 1, j);
            }
        }
        System.out.println("leaf:" + leaf);

        //反向寻找最优解路径leaf->root
        List<String> bestPath = new ArrayList<>();
        List<Integer> bestValues = new ArrayList<>();
        do {
            String[] position = leaf.split("-");
            int i = Integer.valueOf(position[0]);
            int j = Integer.valueOf(position[1]);
            bestValues.add(triangle.get(i).get(j));
            bestPath.add(leaf);
            leaf = path.get(leaf);
        } while (leaf != null);
        Collections.reverse(bestValues);
        Collections.reverse(bestPath);
        System.out.println(bestValues);
        System.out.println(bestPath);
        return value;
    }

    /**
     * 思想: 用记忆化搜索+递归+终止条件
     * 终止条件: 该位置的值已经求出(先给所有位置设置一个状态值,来表示值还未求出
     * dp[i][j],从该位置到底部的最小和
     * dp[i][j]=max(dp[i][j],dp[i][j+1])+a[i][j]
     */
    private int m;
    private int n;
    private int[][] dp;
    private List<List<Integer>> nums;

    public int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle.size() == 1) return triangle.get(0).get(0);
        nums = triangle;
        m = triangle.size();
        n = triangle.get(m - 1).size();
        dp = new int[m][n];
        //将状态都变为-1;
        for (int i = 0; i < m; i++) Arrays.fill(dp[i], Integer.MAX_VALUE);
        return helper(0, 0);
    }

    private int helper(int i, int j) {
        if (dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        if (i == m - 1) return nums.get(i).get(j);
        dp[i][j] = nums.get(i).get(j) + Math.min(helper(i + 1, j), helper(i + 1, j + 1));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] nums = {{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}};
        List<List<Integer>> all = new ArrayList<>();
        for (int[] row : nums) {
            List<Integer> one = new ArrayList<>();
            for (int x : row) one.add(x);
            all.add(one);
        }
        Q120_triangle s = new Q120_triangle();
        int i = s.minimumTotal3(all);
        System.out.println(i);
    }

}
