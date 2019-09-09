package 栈;

import java.util.Stack;

public class Q921_minimum_add_to_make_parentheses_valid {
    public int minAddToMakeValid(String S) {
        /*
        思入: stack ,遍历, 遇到(就进去, 碰到)就出栈(若栈顶没有对应的(,则说明缺少一个()
         */
        Stack<Integer> stack = new Stack<>();
        char[] chars = S.toCharArray();
        int result = 0;
        for (int i = 0; i < chars.length; i++) {
            if ('(' == chars[i]) stack.add(i);
            else {
                if (stack.isEmpty()) result++;
                else stack.pop();
            }
        }
        return result + stack.size();
    }

    public static void main(String[] args) {
        String[] demos = {"())", "(((", "()", "()))(("};
        Q921_minimum_add_to_make_parentheses_valid s = new Q921_minimum_add_to_make_parentheses_valid();
        for (String demo : demos) {
            System.out.println(demo + "  " + s.minAddToMakeValid(demo));
        }
    }
}
