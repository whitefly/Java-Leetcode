package 剑指Offer;

import java.util.Stack;

public class O33_er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie_lcof {
    public boolean verifyPostorder(int[] postorder) {
        int parentVal = Integer.MAX_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (parentVal < postorder[i]) return false;
            while (!stack.isEmpty() && stack.peek() > postorder[i]) {
                parentVal = stack.pop();
            }
            stack.push(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 6, 5};
        O33_er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie_lcof s = new O33_er_cha_sou_suo_shu_de_hou_xu_bian_li_xu_lie_lcof();
        boolean b = s.verifyPostorder(nums);
        System.out.println(b);
    }
}
