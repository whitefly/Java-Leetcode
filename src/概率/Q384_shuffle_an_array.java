package 概率;

import java.util.Arrays;
import java.util.Random;

public class Q384_shuffle_an_array {
    static class Solution {
        //基于抽牌暴力法的优化
        private int[] initArray;
        private int[] tempArray;
        private Random random;

        public Solution(int[] nums) {
            initArray = nums;
            tempArray = nums.clone();
            random = new Random();
        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            tempArray = initArray.clone();
            return tempArray;
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            for (int i = 0; i < initArray.length; i++) {
                swap(tempArray, i, getRandomNum(i, initArray.length));
            }
            return tempArray;
        }

        private void swap(int[] nums, int L, int R) {
            int temp = nums[L];
            nums[L] = nums[R];
            nums[R] = temp;
        }

        private int getRandomNum(int min, int max) {
            //[min,max)
            return random.nextInt(max - min) + min;
        }
    }

    /**
     * Your Solution object will be instantiated and called as such:
     * Solution obj = new Solution(nums);
     * int[] param_1 = obj.reset();
     * int[] param_2 = obj.shuffle();
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));

    }
}
