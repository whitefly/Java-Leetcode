package 滑动窗口;

public class Q1004_max_consecutive_ones_iii {
    public int longestOnes(int[] A, int K) {
        /*
        思入: 滑动窗口
         条件: 范围内的0个数<=k, 若不符合,左移动直到符合
         */
        int zeroCount = 0, result = 0;
        for (int L = 0, R = 0; R < A.length; R++) {
            if (A[R] == 0) {
                zeroCount++;
                while (zeroCount > K) {
                    if (A[L] == 0) zeroCount--;
                    L++;
                }
            }
            result = Math.max(result, R - L + 1);
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] A = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int[] A = {0, 0, 0, 1};
        int K = 2;
        Q1004_max_consecutive_ones_iii s = new Q1004_max_consecutive_ones_iii();
        System.out.println(s.longestOnes(A, K));
    }
}
