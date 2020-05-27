package 剑指Offer;

public class O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof {
    public int singleNumber(int[] nums) {
        //记录每个数的1的个数. 真值表那种方法感觉可以说说听听,不适合写出
        short[] counter = new short[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++, num >>>= 1) {
                counter[i] += (num & 1);
            }
        }
        //都%3;
        int result = 0;
        for (int i = 0, mask = 1; i < 32; i++, mask <<= 1) {
            if ((counter[i] %= 3) == 1) {
                result |= mask;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof s = new O56_shu_zu_zhong_shu_zi_chu_xian_de_ci_shu_ii_lcof();
        int[] nums = {9, 1, 7, 9, 7, 9, 7};
        System.out.println(s.singleNumber(nums));

    }
}
