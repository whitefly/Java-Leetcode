package 剑指Offer;

import java.util.Stack;

public class O31_zhan_de_ya_ru_dan_chu_xu_lie_lcof {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        //用一个栈来模拟,相互抵消
        Stack<Integer> stack = new Stack<>();
        for (int i = 0, index = 0; i < pushed.length; i++) {
            stack.push(pushed[i]);
            //判断是否和弹出序列匹配到
            while (!stack.isEmpty() && stack.peek() == popped[index]) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}
