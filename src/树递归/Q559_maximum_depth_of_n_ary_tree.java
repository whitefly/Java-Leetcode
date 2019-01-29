package 树递归;

public class Q559_maximum_depth_of_n_ary_tree {
    public int maxDepth(Node root) {
        /**
         * 思入: 向上传本节点的最大的深度
         */
        if (root == null) return 0;

        int temp_depth = 0;
        for (Node child : root.children) temp_depth = Math.max(maxDepth(child), temp_depth);
        return temp_depth + 1;
    }
}
