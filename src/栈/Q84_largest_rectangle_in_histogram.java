package 栈;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Q84_largest_rectangle_in_histogram {
    public int largestRectangleArea(int[] heights) {
        /**
         *思入1:  某点的面积,就是该点为高, 得到左边第一个比它低的下标,和右边第一个比它低的下标
         * 从左往右扫,维护一个递增栈.
         * 从右往左扫,维护一个递增栈
         * leftMost[i]为从自己出发向左第一个比它小的数下标
         * rightMost[i]为从自己出发向右第一个比它小的数下标
         *
         * 问题: 扫一遍,能不能得到这个  得到左边不低于它的最远点 的dp数组?   使用递增stack
         */
        if (heights.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int[] leftMost = new int[heights.length];
        int[] rightMost = new int[heights.length];
        //得到左边
        stack.add(0);
        leftMost[0] = -1;
        for (int i = 1; i < heights.length; i++) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            leftMost[i] = stack.empty() ? -1 : stack.peek();
            stack.add(i);
        }
        stack.clear();
        //得到右边
        stack.add(heights.length - 1);
        rightMost[heights.length - 1] = heights.length;
        for (int i = heights.length - 2; i >= 0; i--) {
            while (!stack.empty() && heights[stack.peek()] >= heights[i]) stack.pop();
            rightMost[i] = stack.empty() ? heights.length : stack.peek();
            stack.add(i);
        }
        //计算最大面积
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            result = Math.max((rightMost[i] - leftMost[i] - 1) * heights[i], result);
        }
        return result;
    }

    public int largestRectangleArea2(int[] heights) {
        /**
         * 思入: 扫一遍就完成的思入: 若每次元素的是左边局部最大,那么根本就不用求它的leftMost[].
         * 当一个元素从单调栈被弹出时,它的第一个左边最小的现在的栈顶元素.它就是左边局部最大的.只需要找rightMost即可.
         * 当一个元素从单调栈被弹出时,肯定是右边遇到了比他小的.此时遍历的元素就是rightMost(真tm巧合).
         */
        //在末尾加一个0,让每个元素都可以出栈
        int[] temp = new int[heights.length + 1];
        System.arraycopy(heights, 0, temp, 0, heights.length);
        temp[heights.length] = 0;
        heights = temp;

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.empty() && heights[i] < heights[stack.peek()]) {
                Integer top = stack.pop();
                int leftMost = stack.empty() ? -1 : stack.peek();
                int rightMost = i; //若此时stack为空,则top是[0,i]元素中最小的,i就是
                result = Math.max(result, heights[top] * (rightMost - leftMost + 1 - 2));
            }
            stack.push(i);
        }
        return result;
    }


    public static void main(String[] args) {
        Q84_largest_rectangle_in_histogram s = new Q84_largest_rectangle_in_histogram();
//        int[] nums = {2, 1, 5, 6, 2, 3};
        int[] nums = {1, 2};
        System.out.println(s.largestRectangleArea2(nums));
    }
}
