package 哈希;

import java.util.TreeSet;

public class Q220_contains_duplicate_iii {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        /**
         * 思想:方法1,暴力法
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(i - j) <= k && Math.abs((long) nums[i] - nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        /**
         *  思入2:使用树来快速找到最近的元素
         */
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            Long ceiling = set.ceiling((long) nums[i] - t);
            if (ceiling != null && ceiling <= ((long) nums[i] + t)) return true;
            set.add((long) nums[i]);
            if (set.size() > k) set.remove((long) nums[i - k]);
        }
        return false;
    }

    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int k = 3;
//        int t = 0;
////
//        int[] nums = {1, 0, 1, 1};
//        int k = 1;
//        int t = 2;

        int[] nums = {1, 5, 9, 1, 5, 9};
        int k = 2;
        int t = 3;


        Q220_contains_duplicate_iii s = new Q220_contains_duplicate_iii();
        boolean b = s.containsNearbyAlmostDuplicate(nums, k, t);
        System.out.println(b);


    }
}
