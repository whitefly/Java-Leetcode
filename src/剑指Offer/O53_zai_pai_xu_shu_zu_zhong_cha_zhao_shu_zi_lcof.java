package 剑指Offer;

public class O53_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof {
    public int search(int[] nums, int target) {
        //二分找到第一次出现的位置
        if (nums == null || nums.length == 0) return 0;
        int L = 0, R = nums.length - 1, mid;
        while (L < R) {
            mid = (L + R) / 2;
            if (nums[mid] == target) R = mid;
            else if (nums[mid] < target) L = mid + 1;
            else R = mid - 1;
        }
        int count = 0;
        for (int i = L; i < nums.length; i++) {
            if (nums[i] == target) count++;
            else break;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 2;
        O53_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof s = new O53_zai_pai_xu_shu_zu_zhong_cha_zhao_shu_zi_lcof();
        System.out.println(s.search(nums, target));

    }
}
