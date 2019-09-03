package 栈;

import java.util.Stack;

public class Q856_score_of_parentheses {
    public int scoreOfParentheses(String S) {
        /*
        思入: 使用栈做运算
         */

        Stack<String> stack = new Stack<>();
        for (char c : S.toCharArray()) {
            if ('(' == c) stack.add("(");
            else if (')' == c) {
                String temp;
                int v = 0;
                while (!(temp = stack.pop()).equals("(")) v += Integer.parseInt(temp);

                stack.add(v == 0 ? "1" : v * 2 + "");
            }
        }
        int result = 0;
        while (!stack.isEmpty()) result += Integer.parseInt(stack.pop());
        return result;
    }

    public static void main(String[] args) {
//        String str = "()";
        String str = "(()(()))";
        Q856_score_of_parentheses s = new Q856_score_of_parentheses();
        System.out.println(s.scoreOfParentheses(str));
    }
}
