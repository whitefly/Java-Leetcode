package 概率;

import java.util.Random;

public class Q398_random_pick_index {

    /*
    思入: 蓄水池算法 k=1的特殊情况. 1/k  k表示第k次出现target. 所以不是target就直接跳过
     */
    private Random r;
    private int[] nums;

    public Q398_random_pick_index(int[] nums) {
        r = new Random();
        this.nums = nums;
    }

    public int pick(int target) {
        int result = 0, k = 0;  //k表示第k次出现target
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (0 == r.nextInt(++k)) result = i;
            }
        }
        return result;
    }
}
