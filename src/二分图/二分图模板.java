package 二分图;

import java.util.Arrays;
import java.util.Scanner;

public class 二分图模板 {
    static int[][] map;
    static int n, m;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            int t = cin.nextInt();
            if (t == 0)
                break;
            n = cin.nextInt(); //女生人数,编号从1开始
            m = cin.nextInt(); //男生人数
            map = new int[n + 1][m + 1];
            for (int i = 0; i < t; i++)
                map[cin.nextInt()][cin.nextInt()] = 1; // 有向边
            int count = 0; // 最大匹配数
            int[] matches = new int[m + 1]; // mc[i] = j 表示i号男生所连的女生是j号
            Arrays.fill(matches, -1); // 初始时所有女生都没有连

            for (int i = 1; i <= n; i++) {
                boolean[] vis = new boolean[m + 1]; // vis[i] = true 表示i号男生已经被匹配了,每一次都清空vis?
                if (dfs(i, vis, matches))
                    count++;
            }
            System.out.println(count);
        }
    }

    private static boolean dfs(int start, boolean[] vis, int[] mc) {
        /**
         * dfs的含义: 能否在没有遍历的男生
         */
        //start是要匹配的女生,遍历下一个要匹配的男生()
        for (int i = 1; i <= m; i++) { // 枚举男生集

            //某个男生还是非饱和,且和这个女生有边相连
            if (!vis[i] && map[start][i] == 1) {

                // 将这个男生标记为饱和
                vis[i] = true;

                //这个男生没有女生匹配,那么就跟他匹配, 若该男生有女生匹配了,但是这个女生还有其他选择
                if (mc[i] == -1 || dfs(mc[i], vis, mc)) {
                    mc[i] = start;
                    return true;
                }
            }
        }
        return false;
    }
}
