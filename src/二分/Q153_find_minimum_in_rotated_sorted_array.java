package 二分;

public class Q153_find_minimum_in_rotated_sorted_array {
    public int findMin(int[] nums) {
        /**
         * 思入:   2个正序数组的二分查找.  用mid的左右来进行判断.由于 最后总会剩下2个,所以mid+1是不会越界的
         */
        int l = 0, r = nums.length - 1;
        while (l < r) {
            if (nums[l] < nums[r]) return nums[l]; //已经单个有序数组
            int mid = (l + r) / 2;
            if (nums[mid] >= nums[l]) {
                //mid在左部分
                l = mid + 1;
            } else {
                //mid在右部分
                r = mid;
            }
        }
        return Math.min(nums[l], nums[r]);
    }

    public static void main(String[] args) {
        int[] nums = {3};
        Q153_find_minimum_in_rotated_sorted_array s = new Q153_find_minimum_in_rotated_sorted_array();
        int min = s.findMin(nums);
        System.out.println(min);
    }
}
