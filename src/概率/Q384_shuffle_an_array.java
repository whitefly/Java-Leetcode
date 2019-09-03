package 概率;

import java.util.Arrays;
import java.util.Random;

public class Q384_shuffle_an_array {
    static class Solution {
        int[] initNum;
        Random r;


        public Solution(int[] nums) {
            initNum = nums;
            r = new Random();

        }

        /**
         * Resets the array to its original configuration and return it.
         */
        public int[] reset() {
            return Arrays.copyOfRange(initNum, 0, initNum.length);
        }

        /**
         * Returns a random shuffling of the array.
         */
        public int[] shuffle() {
            /*
             基于抽牌法完成shuffle
             */
            int[] result = Arrays.copyOfRange(initNum, 0, initNum.length);

            for (int i = result.length - 1; i >= 0; i--) {
                int index = r.nextInt(i + 1);
                swap(result, i, index);
            }
            return result;
        }

        private void swap(int[] nums, int a, int b) {
            int temp = nums[a];
            nums[a] = nums[b];
            nums[b] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        Solution s = new Solution(nums);
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));
        System.out.println(Arrays.toString(s.shuffle()));

    }
}
