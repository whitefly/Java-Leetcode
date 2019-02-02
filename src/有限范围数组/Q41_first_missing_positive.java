package 有限范围数组;

public class Q41_first_missing_positive {
    public int firstMissingPositive(int[] nums) {
        /**
         * 思想: 索引法: 将元素看做索引. ≤0的元素索引直接跳过. 设置一个boolean数组做好标记true
         * 最后遍历该布尔数组,找出一个false的下标,+1然后返回. 或扫完都木有.返回size+1
         */

        boolean[] gone = new boolean[nums.length];
        int size = nums.length;
        for (int num : nums) if (0 < num && num <= size) gone[num - 1] = true;
        //找出一个false;
        for (int i = 0; i < nums.length; i++) if (!gone[i]) return i + 1;
        return size + 1;
    }

    public int firstMissingPositive2(int[] nums) {
        /**
         * 思入: 索引法的升级.直接将 索引数字,移动到正确的位置上(交换).交换来的元素,进行再次移动(链式反应).直到碰到!(0 < num && num <= size)就停下
         */
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            while (0 < nums[i] && nums[i] <= size && nums[i] - 1 != i) {
                if (nums[nums[i] - 1] == nums[i]) break;
                swap(nums, nums[i] - 1, i);
            }
        }
        //找第一个索引和元素不符合
        for (int i = 0; i < size; i++) if (i != nums[i] - 1) return i + 1;
        return size + 1;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q41_first_missing_positive s = new Q41_first_missing_positive();
        int[] nums = {1, 1};
        int i = s.firstMissingPositive2(nums);
        System.out.println(i);
    }
}
