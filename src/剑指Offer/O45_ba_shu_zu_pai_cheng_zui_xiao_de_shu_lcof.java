package 剑指Offer;

import java.util.Arrays;
import java.util.Comparator;

public class O45_ba_shu_zu_pai_cheng_zui_xiao_de_shu_lcof {
    public static String minNumber(int[] nums) {
        //这题好难想到 是 ab 和 ba进行比较来排序哇
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) strNums[i] = String.valueOf(nums[i]);

        Arrays.sort(strNums, (o1, o2) -> (o1+o2).compareTo(o2+o1));
        StringBuilder sb = new StringBuilder();
        for (String item : strNums) sb.append(item);
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};
        String s = minNumber(nums);
        System.out.println(s);
    }
}
