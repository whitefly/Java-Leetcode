package 栈;

import java.util.Stack;

public class Q844_backspace_string_compare {
    public boolean backspaceCompare(String S, String T) {
            /*
            思入: 2个stack,碰到<-就从栈中出来
             */
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        for (char c : S.toCharArray()) {
            if ('#' == c) {
                if (!s1.isEmpty()) s1.pop();
            } else s1.add(c);
        }
        for (char c : T.toCharArray()) {
            if ('#' == c) {
                if (!s2.isEmpty()) s2.pop();
            } else s2.add(c);
        }
        return s1.equals(s2);
    }

    public static void main(String[] args) {
        String str1 = "xywrrmp";
        String str2 = "xywrrmu#p";
        Q844_backspace_string_compare s = new Q844_backspace_string_compare();
        System.out.println(s.backspaceCompare(str1, str2));
    }
}
