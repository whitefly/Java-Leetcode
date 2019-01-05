package 二分;

public class Q81_search_in_rotated_sorted_array_ii {
    public boolean search(int[] nums, int target) {
        /**
         * 思入: 2个正序数组的二分搜索变种. 4种况依然适用,
         * 需要初始明确划分左右.将右边的边界的重复元素删除.其他不变
         */

        int l = 0, r = nums.length - 1;
        //删除右边边界重复元素
        while (l < r && nums[l] == nums[r]) r--;

        while (l <= r) {
            int mid = (l + r) / 2;
            if (target == nums[mid]) return true;

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
        return false;
    }

    public static void main(String[] args) {
        Q81_search_in_rotated_sorted_array_ii s = new Q81_search_in_rotated_sorted_array_ii();
        int[] nums = {2, 5, 6, 0, 0, 1, 2};
        System.out.println(s.search(nums, 3));
    }


}
