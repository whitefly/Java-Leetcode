package 树递归;

public class Q236_lowest_common_ancestor_of_a_binary_tree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /**
         * 思入:  若左子有,右子有,则它是第一个祖先,不断将它的val向上传
         * 若左子有,右子没有,则父节点标号
         */
        if (root == null) return null;
        //后序
        TreeNode l = lowestCommonAncestor(root.left, p, q);
        TreeNode r = lowestCommonAncestor(root.right, p, q);
        //根据本身和左右子的情况,选项向上传递的变量
        if (root == p || root == q) return root;
        if (l != null && r != null) return root;
        else if (l != null) return l;
        else if (r != null) return r;
        else return null;
    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //目标1或者目标2的在该节点下的最远父亲 或者 目标1+目标2的共同最近祖先
        if (root == null) return null;
        TreeNode l = lowestCommonAncestor2(root.left, p, q);
        TreeNode r = lowestCommonAncestor2(root.right, p, q);

        //情况1: 若当前root就是子节点,那么自己也是自己的祖先
        if (root == p || root == q) return root;
        //情况2: l,r的返回值都存在,说明root节点是最近共同祖先,返回即可
        if (l != null && r != null) return root;
        //情况3: 2个返回值只有1个不为null值,说明 一:可能不为null的返回值就是最后结果 二: 可能只目标1或者目标2的父亲,需要继续向上传
        //若是一,则会一直传到外面作为result, 若是二,继续向上传迟早会触发情况2,也返回正确的result
        return l != null ? l : r;
    }


}
