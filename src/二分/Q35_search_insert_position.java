package 二分;

public class Q35_search_insert_position {
    public int searchInsert(int[] nums, int target) {
        /**
         * 思入:  最后取值: 若右指针<0,则取右指针+1  其他情况都取最后的左指针
         */

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        if (r < 0) return 0;
        else return l;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int target = 0;
        Q35_search_insert_position s = new Q35_search_insert_position();
        int i = s.searchInsert(nums, target);
        System.out.println(i);
    }
}
