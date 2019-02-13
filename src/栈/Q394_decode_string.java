package 栈;

import java.util.Stack;

public class Q394_decode_string {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        int size = s.length(), index = 0;
        char[] chars = s.toCharArray();
        while (index < size) {
            if (chars[index] == '[') {
                //碰到'['
                stack.push("[");
                index++;
            } else if (Character.isDigit(chars[index])) {
                //碰到 数字100
                int end = s.indexOf('[', index);
                stack.push(s.substring(index, end));
                index = end;
            } else if (Character.isLetter(chars[index])) {
                //碰到 字符abc
                int end = index;
                while (end < size && Character.isLetter(chars[end])) end++;
                stack.push(s.substring(index, end));
                index = end;
            } else {
                //碰到']',出栈,直到碰到数字
                StringBuilder temp = new StringBuilder();
                while (!stack.peek().equals("[")) temp.insert(0, stack.pop());

                stack.pop();
                int time = Integer.valueOf(stack.pop()); //重复次数
                StringBuilder all = new StringBuilder();
                for (int i = 0; i < time; i++) all.append(temp);
                //判断是否再次进入stack
                if (!stack.isEmpty()) stack.push(all.toString());
                else result.append(all.toString());
                index++;
            }
        }
        int end = result.length();
        while (!stack.isEmpty()) result.insert(end, stack.pop());
        return result.toString();
    }

    public static void main(String[] args) {
        String str = "2[abc]3[cd]ef";
        Q394_decode_string s = new Q394_decode_string();
        System.out.println(s.decodeString(str));
    }
}
