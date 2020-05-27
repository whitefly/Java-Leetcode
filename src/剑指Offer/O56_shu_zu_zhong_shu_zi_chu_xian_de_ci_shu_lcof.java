package 剑指Offer;

import java.util.Arrays;

public class O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof {
    public int[] singleNumbers(int[] nums) {
        //异或的位运算,找到2个数的特征位数,属于特征1的放一部分,属于特征2的放另一个部分
        int feature = 0;
        for (int num : nums) feature ^= num;
        //找到左边第一个为1的bit的作为mask筛子
        int select = (feature & -feature);
        int num1 = 0, num2 = 0;
        for (int num : nums) {
            if ((num & select) == 0) num1 ^= num;
            else num2 ^= num;
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 10, 4, 1, 4, 3, 3};
        O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof s = new O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_lcof();
        int[] ints = s.singleNumbers(nums);
        System.out.println(Arrays.toString(ints));
    }
}
