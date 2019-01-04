package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q60_permutation_sequence {
    StringBuilder temp = new StringBuilder();
    boolean gone[];
    boolean end = false;
    int my_k;
    String r;


    public String getPermutation(int n, int k) {
        /**
         * 思入1: 深度搜索找到所有路径(回溯剪枝). 分支是还没有使用的数字(所以设置一个gone变量). 由于是第k个,需要记个数,达到k时才加入结果集
         * 时间: ,但是由于找到后直接剪枝后面的,所以没超时.但是耗时还是比较慢
         */
        my_k = k;
        gone = new boolean[n + 1];
        hepler(n);
        return r;

    }

    private void hepler(int n) {
        if (end) return;
        if (temp.length() == n) {
            my_k--;
            if (my_k == 0) {
                r = temp.toString();
                end = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (gone[i]) continue;
            gone[i] = true;
            temp.append(i);
            hepler(n);
            gone[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q60_permutation_sequence s = new Q60_permutation_sequence();
        String permutation = s.getPermutation(4, 9);
        System.out.println(permutation);
    }
}
