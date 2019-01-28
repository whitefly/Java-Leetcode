package 树递归;

import java.util.Stack;

public class Q331_verify_preorder_serialization_of_a_binary_tree {
    public boolean isValidSerialization(String preorder) {
        /**
         * 思入: 采用stack的思想, 核心是 怎么知道左边已经遍历完了? 用一个#来填充
         * 规则: 若顶上为# ,且又碰上#,则叶节点已经遍历完. 消去叶节点,且再加一个#,表示其左枝已经遍历完.
         */
        Stack<String> stack = new Stack<>();
        try {
            for (String c : preorder.split(",")) {
                if (c.equals(",")) continue;

                if (!c.equals("#")) stack.push(c);
                else {
                    if (stack.isEmpty() || stack.peek().equals("#")) stack.push("#");
                    else {
                        while (stack.peek().equals("#")) {
                            stack.pop();  //去掉#
                            String second = stack.pop();//去掉最近顶点
                            // if (second.equals("#")) return false;
                            if (stack.size() == 0) break;
                        }
                        stack.push("#");  //加上节点
                    }
                }
            }

            return stack.size() == 1 && stack.peek().equals("#");  //最后stask已经只剩下一个#
        } catch (Exception e) {
            return false;
        }


    }

    public boolean isValidSerialization2(String preorder) {
        /**
         * 思入: 利用节点和边的个数. 将#看做叶节点,数字节点看做非叶节点  则满足n0=n2+1
         * 且这个式子,只有遍历完后,才满足,或前提出现.一定不满足
         */
        int n0 = 0, n2 = 0;
        String[] nums = preorder.split(",");
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            String c = nums[i];
            if (c.equals("#")) n0++;
            else n2++;
            // 若提前满足等式,则一定不符合
            if (i < size - 1 && n0 == n2 + 1) return false;
        }
        return n0 == n2 + 1;

    }

    public static void main(String[] args) {
        String str = "9,#,92,#,#";
        Q331_verify_preorder_serialization_of_a_binary_tree s = new Q331_verify_preorder_serialization_of_a_binary_tree();
        boolean validSerialization = s.isValidSerialization(str);
        System.out.println(validSerialization);
    }
}
