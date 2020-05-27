package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;

public class O61_bu_ke_pai_zhong_de_shun_zi_lcof {
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        int miss = 0, kind = 0, last = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) kind++;
            else {
                if (last != -1) {
                    if (nums[i] == last) return false; //出现重复
                    else miss += nums[i] - last - 1;
                }
                last = nums[i];
            }
        }
        return kind >= miss;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 2, 6};
        O61_bu_ke_pai_zhong_de_shun_zi_lcof s = new O61_bu_ke_pai_zhong_de_shun_zi_lcof();
        System.out.println(s.isStraight(nums));
    }
}
