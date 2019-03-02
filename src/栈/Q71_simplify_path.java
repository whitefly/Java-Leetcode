package 栈;

import java.util.Arrays;
import java.util.Stack;

public class Q71_simplify_path {
    public String simplifyPath(String path) {
        /**
         *  思入: 使用stack, 一旦出现 //..就出栈. 若栈内没有,就忽略掉.最后stack剩下的元素,组成字符串.
         */
        Stack<String> stack = new Stack<>();
        for (String one : path.split("/+")) {
            if (one.equals("") || one.equals(".")) continue;
            if (!one.equals("..")) stack.push(one);
            else if (!stack.empty()) stack.pop();
        }
        //重组
        StringBuilder result = new StringBuilder();
        for (String one : stack) result.append("/").append(one);
        return result.length() == 0 ? "/" : result.toString();
    }


    public static void main(String[] args) {
        String str = "/../";
        Q71_simplify_path s = new Q71_simplify_path();
        String s1 = s.simplifyPath(str);
        System.out.println(s1);
    }
}
