package 剑指Offer;

public class O39_shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof {
    public int majorityElement(int[] nums) {
        //摩尔排序
        int leader = -1;
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                count++;
                leader = num;
            } else {
                if (leader != num) count--;
                else count++;
            }
        }
        return leader;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 2, 2, 5, 4, 2};
        O39_shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof s = new O39_shu_zu_zhong_chu_xian_ci_shu_chao_guo_yi_ban_de_shu_zi_lcof();
        System.out.println(s.majorityElement(nums));
    }
}
