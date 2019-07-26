package 位运算;

import java.util.Arrays;

public class Q338_counting_bits {
    public int[] countBits(int num) {
        /*
         * 思入: n&n-1 和动态规划的思想.
         * x=n&n-1  x比n少一个1,比n小. 所以可以利用前面的x来计算出n的比特数
         * len(n)=len(n&n-1)+1,然后通过递推式求出所有
         */
        int[] dp = new int[num + 1];
        for (int i = 1; i < dp.length; i++) dp[i] = dp[i & (i - 1)] + 1;
        return dp;
    }

    public static void main(String[] args) {
        int num = 5;
        Q338_counting_bits s = new Q338_counting_bits();
        int[] result = s.countBits(num);
        System.out.println(Arrays.toString(result));
    }
}
