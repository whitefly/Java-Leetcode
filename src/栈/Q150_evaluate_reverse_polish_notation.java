package 栈;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q150_evaluate_reverse_polish_notation {
    public int evalRPN(String[] tokens) {
        /**
         * 思入: 一个数字stack,一旦碰到符号,就从其中取出2数字计算,然后返回栈中
         */
        Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        Stack<Integer> nums = new Stack<>();
        for (String item : tokens) {
            if (!set.contains(item)) {
                nums.add(Integer.valueOf(item));
            } else {
                int num2 = nums.pop();
                int num1 = nums.pop();
                if (item.equals("+")) {
                    nums.add(num1 + num2);
                } else if (item.equals("-")) {
                    nums.add(num1 - num2);
                } else if (item.equals("*")) {
                    nums.add(num1 * num2);
                } else {
                    nums.add(num1 / num2);
                }
            }
        }
        return nums.peek();
    }

    public static void main(String[] args) {
        String[] ops = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        Q150_evaluate_reverse_polish_notation s = new Q150_evaluate_reverse_polish_notation();

        int i = s.evalRPN(ops);
        System.out.println(i);

    }

}
