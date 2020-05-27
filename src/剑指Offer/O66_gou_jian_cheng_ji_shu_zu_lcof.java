package 剑指Offer;

import java.util.Arrays;

public class O66_gou_jian_cheng_ji_shu_zu_lcof {
    public static int[] constructArr(int[] a) {
        int left = 1, right = 1;
        int[] dp = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            dp[i] = left;
            left *= a[i];
        }
        for (int i = a.length - 1; i >= 0; i--) {
            dp[i] = i > 0 ? dp[i] * right : right;
            right *= a[i];
        }
        return dp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] ints = constructArr(nums);
        System.out.println(Arrays.toString(ints));

    }
}
