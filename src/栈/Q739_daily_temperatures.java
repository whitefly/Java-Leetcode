package 栈;

import java.util.Arrays;
import java.util.Stack;

public class Q739_daily_temperatures {
    public static int[] dailyTemperatures(int[] T) {
        // 单调栈,↑小
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && T[stack.peek()] < T[i]) {
                int pop = stack.pop();
                result[pop] = i - pop;
            }
            stack.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = Q739_daily_temperatures.dailyTemperatures(temperatures);
        System.out.println(Arrays.toString(ints));

    }
}
