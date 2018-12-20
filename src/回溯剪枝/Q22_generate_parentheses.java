package 回溯剪枝;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Q22_generate_parentheses {
    /**
     * 思入: 回缩剪枝, 用一个stack和(数量来判断是否需要剪枝
     */
    private Stack<Character> stack = new Stack<>();
    private int size_of_left = 0;
    private List<String> r = new ArrayList<>();
    private int size;
    private int double_size;


    public List<String> generateParenthesis(int n) {
        size = n;
        double_size = 2 * n;
        StringBuilder s = new StringBuilder(128);
        helper(s);
        return r;
    }

    public void helper(StringBuilder s) {
        //终止节点
        if (s.length() == double_size) {
            if (stack.empty()) r.add(s.toString());
            return;
        }
        if (size_of_left > size) return;  //提前剪枝

        //增加'('
        size_of_left++;
        stack.push('(');
        s.append('(');
        helper(s);
        size_of_left--;
        stack.pop();
        s.deleteCharAt(s.length() - 1);

        //增加')'
        if (stack.empty()) return;
        stack.pop();
        s.append(')');
        helper(s);
        stack.add('(');
        s.deleteCharAt(s.length() - 1);
    }

    public static void main(String[] args) {
        Q22_generate_parentheses s = new Q22_generate_parentheses();
        System.out.println(s.generateParenthesis(3));


    }

}
