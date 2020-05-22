package 剑指Offer;

import java.util.Arrays;

public class O21_diao_zheng_shu_zu_shun_xu_shi_qi_shu_wei_yu_ou_shu_qian_mian_lcof {
    public static int[] exchange(int[] nums) {
        if (nums.length <= 1) return nums;
        int store = 0; //存放奇数
        for (int i = 1; i < nums.length; i++) {
            if ((nums[i] & 1) == 1) {
                swap(nums, ++store, i);
            }
        }
        //最后store是最后的奇数位置
        if ((nums[0] & 1) != 1) swap(nums, 0, store);
        return nums;
    }

    static void swap(int[] nums, int L, int R) {
        int temp = nums[L];
        nums[L] = nums[R];
        nums[R] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] exchange = exchange(nums);
        System.out.println(Arrays.toString(exchange));

    }
}
