package 树递归;

import java.util.LinkedList;
import java.util.Queue;

public class Q662_maximum_width_of_binary_tree {

    class element {
        TreeNode node;
        int index;

        element(TreeNode node, int index) {
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        /**
         * 思入:  层次遍历的写法,需要记录 begin 和 end 节点的下标. 记录该节点的位置,该节点在本层的位置由父节点确定
         */
        if (root == null) return 0;
        int result = 0;
        Queue<element> Q = new LinkedList();

        Q.offer(new element(root, 1));
        while (!Q.isEmpty()) {
            int size = Q.size();
            int begin = -1, end = -1;

            for (int i = 0; i < size; i++) {
                element temp = Q.poll();
                int index = temp.index;
                TreeNode node = temp.node;

                //end总是指向最后一个
                if (begin == -1) begin = index;
                end = index;

                //根据父节点,计算在满二叉树下,子节点的位置 分别是2n-1 和 2n
                if (node.left != null) Q.offer(new element(node.left, index * 2 - 1));
                if (node.right != null) Q.offer(new element(node.right, index * 2));
            }
            result = Math.max(result, end - begin + 1);
        }
        return result;


    }
}
