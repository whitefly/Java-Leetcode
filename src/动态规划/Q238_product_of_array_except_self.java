package 动态规划;

import java.util.Arrays;

public class Q238_product_of_array_except_self {

    public int[] productExceptSelf(int[] nums) {
        /**
         *思入:延时dp问题,最后的结果= 左乘积*右乘积. dp[i]表示 0-i元素的乘积
         */
        int size = nums.length;
        int[] left_prod = new int[size], result = new int[size];
        //左乘积
        for (int i = 0; i < size; i++) left_prod[i] = (i == 0) ? nums[i] : left_prod[i - 1] * nums[i];
        //右乘积
        int left, right;
        for (int i = size - 1; i >= 0; i--) {
            left = (i == 0) ? 1 : left_prod[i - 1]; //左乘积
            left_prod[i] = (i == size - 1) ? nums[i] : nums[i] * left_prod[i + 1];
            right = (i == size - 1) ? 1 : left_prod[i + 1]; //右乘积
            result[i] = left * right;
        }
        return result;
    }

    public int[] productExceptSelf2(int[] nums) {
        /**
         *思入2: 在原来基础上,可以用result当做left_prod使用
         */
        int size = nums.length;
        int[] result = new int[size];
        //左乘积
        for (int i = 0; i < size; i++) result[i] = (i == 0) ? nums[i] : result[i - 1] * nums[i];
        //右乘积
        int left, right, last_right = 1;
        for (int i = size - 1; i >= 0; i--) {
            left = (i == 0) ? 1 : result[i - 1]; //左乘积
            right = (i == size - 1) ? 1 : last_right; //右乘积
            result[i] = left * right;
            last_right = (i == size - 1) ? nums[i] : nums[i] * last_right; //更新下一轮的右乘积
        }
        return result;
    }


    public static void main(String[] args) {
        Q238_product_of_array_except_self s = new Q238_product_of_array_except_self();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(s.productExceptSelf2(nums)));

    }
}
