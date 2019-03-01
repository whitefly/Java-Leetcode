package 二分;

public class Q162_find_peak_element {
    public int findPeakElement(int[] nums) {
        /**
         * 思入: 普通2分.
         */
        int L = 0, R = nums.length - 1, size = nums.length;
        while (L < R) {
            int mid = (L + R) / 2;
            if (mid + 1 == size) R = mid;
            if (nums[mid] < nums[mid + 1]) L = mid + 1;
            else R = mid;
        }
        return L;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        Q162_find_peak_element s = new Q162_find_peak_element();
        int peakElement = s.findPeakElement(nums);
        System.out.println(peakElement);

    }
}

