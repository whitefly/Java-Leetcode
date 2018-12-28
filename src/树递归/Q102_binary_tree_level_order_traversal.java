package 树递归;


import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Q102_binary_tree_level_order_traversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 思入1:开始一层的root节点的左子 同样也是下一层的头位置(head节点的传承).若没有,找到同层中第一个有子树的来传承
         */

        Queue<TreeNode> Q = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        List<Integer> row = new ArrayList<>();
        TreeNode head = root;
        Q.add(root);
        while (!Q.isEmpty()) {
            TreeNode temp = Q.poll();
            // 若已经遍历到下一层,将上层结果加入
            if (temp == head) {
                if (row.size() != 0) result.add((List<Integer>) ((ArrayList<Integer>) row).clone());
                row.clear();
                head = null;
            }
            //选出新的head节点
            if (head == null && temp.left != null) head = temp.left;
            if (head == null && temp.right != null) head = temp.right;

            //加入队列
            row.add(temp.val);
            if (temp.left != null) Q.add(temp.left);
            if (temp.right != null) Q.add(temp.right);
        }
        result.add((List<Integer>) ((ArrayList<Integer>) row).clone());
        return result;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        /**
         * 思入2: 通过先序遍历和层级变量,来加到最后的结果集上去
         */
        int level = 0;
        List<List<Integer>> result = new ArrayList<>();
        preOrder(root, level, result);
        return result;
    }

    private void preOrder(TreeNode root, int level, List<List<Integer>> lists) {
        if (root == null) return;
        if (lists.size() - 1 < level) lists.add(new ArrayList<>());
        lists.get(level).add(root.val);
        level++;
        preOrder(root.left, level, lists);
        preOrder(root.right, level, lists);
    }

    public List<List<Integer>> levelOrder3(TreeNode root) {
        /**
         * 思入3:  在遍历一层时,记录下一层的总个数(或者队列中的size就是下一层的数量),然后定点遍历,每次出栈时加入结果集中
         */
        Queue<TreeNode> Q = new LinkedList();
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Q.offer(root);
        while (!Q.isEmpty()) {
            int temp_count = Q.size();
            ArrayList<Integer> container = new ArrayList<>();
            //遍历本层节点,一共有next_count个
            for (int i = 0; i < temp_count; i++) {
                TreeNode temp = Q.poll();
                container.add(temp.val);  //出栈时加入结果集

                if (temp.left != null) Q.offer(temp.left);
                if (temp.right != null) Q.offer(temp.right);
            }
            result.add(container);
        }
        return result;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Q102_binary_tree_level_order_traversal s = new Q102_binary_tree_level_order_traversal();
//        TreeNode root = new TreeNode(1);
//        root.right = new TreeNode(2);
        List<List<Integer>> lists = s.levelOrder3(root);
        System.out.println(lists);
    }


}
