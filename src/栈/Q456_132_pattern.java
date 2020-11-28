package 栈;

import java.util.Stack;

public class Q456_132_pattern {
    public boolean find132pattern(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        for (int i = nums.length - 1, second = Integer.MIN_VALUE; i >= 0; i--) {
            if (nums[i] < second) return true;
            while (!stack.isEmpty() && stack.peek() < nums[i]) {
                second = stack.pop(); //可以保证second总是增大的,如果有个小的,在第9行都已经返回了
            }
            stack.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {};
        Q456_132_pattern solution = new Q456_132_pattern();
        System.out.println(solution.find132pattern(nums));

    }
}
