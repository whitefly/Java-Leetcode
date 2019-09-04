package 双指针;

import java.util.Arrays;

public class Q455_assign_cookies {
    public int findContentChildren(int[] g, int[] s) {
        /*
       思入: 排序+双指针
         */
        Arrays.sort(g);
        Arrays.sort(s);
        int j = 0, count = 0;
        for (int i = 0; i < g.length; i++) {
            while (j < s.length && g[i] > s[j]) j++;

            if (j < s.length && g[i] <= s[j]) {
                count++;
                j++;
            } else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[] target = {3};
        Q455_assign_cookies s = new Q455_assign_cookies();
        System.out.println(s.findContentChildren(nums, target));
    }
}
