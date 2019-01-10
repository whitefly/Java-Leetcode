package 图形学;

import java.util.Arrays;
import java.util.Stack;

public class Q84_largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        /**
         *思入1:  某点的面积,就是该点为高, 得到右边不低于它的最远点, 和左边不低于它的最远点
         * 问题: 扫一遍,能不能得到这个  得到左边不低于它的最远点 的dp数组?   使用递增stack
         */

        Stack<Integer> stack = new Stack<>();
        int size = heights.length;
        int max_area = 0;

        //得到左边第一个比它小的后一个数下标,
        int[] dp = new int[size];
        int right;
        for (int i = 0; i < size; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            dp[i] = stack.empty() ? 0 : stack.peek() + 1;
            stack.push(i);
        }

        stack.clear();
        //得到右边第一个比它小的前一个数下标
        for (int i = size - 1; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            right = stack.empty() ? size - 1 : stack.peek() - 1;
            max_area = Math.max(max_area, heights[i] * (right - dp[i] + 1));
            stack.push(i);
        }
        return max_area;
    }

    public static void main(String[] args) {
        Q84_largest_rectangle_in_histogram s = new Q84_largest_rectangle_in_histogram();
        int[] nums = {1, 1};
        System.out.println(s.largestRectangleArea(nums));
    }
}
