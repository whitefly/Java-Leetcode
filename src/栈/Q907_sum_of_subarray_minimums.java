package 栈;

import java.util.Stack;

public class Q907_sum_of_subarray_minimums {
    public int sumSubarrayMins(int[] A) {
        /*
        思入: 单调栈的变种. 由于在找左右第一个比它小的数,所以使用单调增栈
         */
        Stack<Integer> stack = new Stack<>();
        int[] minL = new int[A.length];
        long result = 0;
        for (int i = 0; i < A.length; i++) {
            while (!stack.empty() && A[stack.peek()] >= A[i]) {
                int target = stack.pop();
                result += getCount(minL[target], target, i - 1) * A[target];
            }
            minL[i] = stack.isEmpty() ? 0 : stack.peek() + 1;
            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int target = stack.pop();
            result += getCount(minL[target], target, A.length - 1) * A[target];
        }
        return (int) (result % 1000000007);
    }

    private int getCount(int L, int i, int R) {
        int t1 = i - L;
        int t2 = R - i;
        int t3 = t1 * t2;
        return t1 + t2 + t3 + 1;
    }

    public static void main(String[] args) {
        int[] nums = {3, 21}; //
        Q907_sum_of_subarray_minimums s = new Q907_sum_of_subarray_minimums();
        System.out.println(s.sumSubarrayMins(nums));
    }
}
