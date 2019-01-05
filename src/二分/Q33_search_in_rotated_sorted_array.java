package 二分;

public class Q33_search_in_rotated_sorted_array {
    public int search(int[] nums, int target) {
        /**
         * 思入:  2个升序三角的二分搜索. 仔细判定2个指针属于哪个区间即可
         */

        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return mid;

            //分2种情况:
            if (nums[l] <= nums[r]) {
                //已经变为单个升序
                if (target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                //依然是2个升序,查看mid落在哪个区间
                if (nums[mid] >= nums[l]) {
                    //mid在左区间时
                    if (target >= nums[l]) {
                        //target在左区间
                        if (target < nums[mid]) r = mid - 1;
                        else l = mid + 1;
                    } else {
                        //target在右区间
                        l = mid + 1;
                    }
                } else {
                    //mid在右区间时
                    if (target <= nums[r]) {
                        //target在右区间
                        if (target < nums[mid]) r = mid - 1;
                        else l = mid + 1;
                    } else {
                        //target在左区间
                        r = mid - 1;
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 3};
        Q33_search_in_rotated_sorted_array s = new Q33_search_in_rotated_sorted_array();
        int r = s.search(nums, 5);
        System.out.println(r);

    }
}
