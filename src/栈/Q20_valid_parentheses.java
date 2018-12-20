package 栈;

import java.util.Stack;

public class Q20_valid_parentheses {
    public boolean isValid(String s) {
        /**
         * 括号匹配,使用3个stack
         */
        Stack<Integer> stack = new Stack<>();
        try {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case '(':
                        stack.push(0);
                        break;
                    case '{':
                        stack.push(1);
                        break;
                    case '[':
                        stack.push(2);
                        break;
                    case ')':
                        if (stack.pop() != 0) return false;
                        break;
                    case '}':
                        if (stack.pop() != 1) return false;
                        break;
                    case ']':
                        if (stack.pop() != 2) return false;
                        break;
                }
            }
            return stack.empty();
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "{[]}";
        Q20_valid_parentheses s = new Q20_valid_parentheses();
        System.out.println(s.isValid(str));

    }
}
