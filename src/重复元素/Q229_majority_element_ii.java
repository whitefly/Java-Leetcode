package 重复元素;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Q229_majority_element_ii {
    public List<Integer> majorityElement(int[] nums) {
            /*
             选2个数作为老大和老二 (只能知道这2个数是出现最多的,但是没法判定是否n/3,所以需要针对性地扫一遍)
             本质: 每次集齐3个不同的然后同归于尽
             其他: 众数i: 每次集齐2个不同的然后同归于尽.
             */
        int num1 = -1, num2 = -2, count1 = 0, count2 = 0;
        for (int num : nums) {
            if (num1 == num) count1++;
            else if (num2 == num) count2++;
            else if (count1 == 0) {
                num1 = num;
                count1++;
            } else if (count2 == 0) {
                num2 = num;
                count2++;
            } else {
                count1--;
                count2--;
            }
        }

        int check1 = 0, check2 = 0;
        for (int num : nums) {
            if (num == num1) check1++;
            else if (num == num2) check2++;
        }
        List<Integer> result = new ArrayList<>();
        if (check1 > nums.length / 3) result.add(num1);
        if (check2 > nums.length / 3) result.add(num2);
        return result;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 1, 1, 3, 3, 2, 2, 2};
//        int[] nums = {3, 2, 3};
        int[] nums = {1, 2, 2, 3, 2, 1, 1, 3};
        Q229_majority_element_ii s = new Q229_majority_element_ii();
        System.out.println(s.majorityElement(nums));
    }
}
