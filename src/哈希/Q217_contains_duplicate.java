package 哈希;

import java.util.HashSet;

public class Q217_contains_duplicate {
    public boolean containsDuplicate(int[] nums) {
        /**
         *  思入: 简单的hash思想
         */
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num)) return true;
            else set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        Q217_contains_duplicate s = new Q217_contains_duplicate();
        int[] nums = {1, 2, 3, 4};
        System.out.println(s.containsDuplicate(nums));
    }
}
