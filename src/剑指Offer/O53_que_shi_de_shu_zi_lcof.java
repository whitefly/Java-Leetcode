package 剑指Offer;

public class O53_que_shi_de_shu_zi_lcof {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    public int missingNumber2(int[] nums) {
        //二分
        if (nums == null || nums.length == 0) return 0;
        int L = 0, R = nums.length - 1, mid;
        while (L < R) {
            mid = (L + R) / 2;
            if (nums[mid] == mid) L = mid + 1;
            else R = mid;
        }
        return nums[L] == L ? nums.length : L;
    }


    public static void main(String[] args) {

    }
}
