package 动态规划;

public class Q42_trapping_rain_water {
    public int trap(int[] height) {
        /**
         * 以每个柱子为单位,每个柱子上能存多少水,取决于它的左最高和右最高.需要用 ->扫一次, <-扫一次,一共2次即可求出.属于延时dp
         */
        int size = height.length;
        int[] left_dp = new int[height.length];
        int result = 0;
        //左边最高
        for (int i = 0; i < size; i++)
            left_dp[i] = (i == 0) ? height[i] : Math.max(left_dp[i - 1], height[i]);
        //右边最高
        for (int i = size - 1; i >= 0; i--) {
            int left_higest = left_dp[i];  //左最高
            left_dp[i] = (i == size - 1) ? height[i] : Math.max(left_dp[i + 1], height[i]); //右最高,重复利用left_dp的空间存储右最高

            result += Math.min(left_higest, left_dp[i]) - height[i];  //添加
        }
        return result;
    }

    public static void main(String[] args) {
        Q42_trapping_rain_water s = new Q42_trapping_rain_water();
        int[] nums = {};
        System.out.println(s.trap(nums));

    }
}
