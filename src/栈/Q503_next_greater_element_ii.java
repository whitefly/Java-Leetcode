package 栈;

import java.util.Arrays;
import java.util.Stack;

public class Q503_next_greater_element_ii {
    public int[] nextGreaterElements(int[] nums) {
        /*
        思入:  单调增栈 可以找到 左起/右起第一个比他小的,
              单调减栈 可以找到 左起/右起第一个比他大的,
              这里找最右器第一个比他大的--->递减栈(弹出时确定),扫二遍即可
         */

        Stack<Integer> stack = new Stack<>();
        int[] max = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                max[stack.pop()] = nums[i];
            }
            stack.add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                max[stack.pop()] = nums[i];
            }
        }
        while (!stack.isEmpty()) max[stack.pop()] = -1;
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1};
        Q503_next_greater_element_ii s = new Q503_next_greater_element_ii();
        System.out.println(Arrays.toString(s.nextGreaterElements(nums)));
    }
}
