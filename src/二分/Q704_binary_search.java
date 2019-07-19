package 二分;

public class Q704_binary_search {
    public int search(int[] nums, int target) {
        /*
        思入: 二分查找的入门题
         */
        int L = 0;
        int R = nums.length - 1;
        int gap;
        while (L <= R) {
            int mid = (L + R) / 2;
            if ((gap = (nums[mid] - target)) == 0) return mid;
            else if (gap > 0) R = mid - 1;
            else L = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {2};
        int target = 2;
        Q704_binary_search s = new Q704_binary_search();
        int search = s.search(nums, target);
        System.out.println(search);
    }
}
