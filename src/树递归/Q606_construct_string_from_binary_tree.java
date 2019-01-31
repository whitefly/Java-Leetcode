package 树递归;

public class Q606_construct_string_from_binary_tree {
    StringBuilder result = new StringBuilder();

    public String tree2str(TreeNode t) {
        /**
         *  思入: 有左子时,在一个"("  出现叶节点时,不用加(), 出现右时,也加一个)  然后返回时,加一个).
         *  有点像回溯剪枝
         */

        if (t == null) return "";
        helper(t);
        return result.toString();

    }

    private void helper(TreeNode t) {
        if (t.left == null && t.right == null) {
            result.append(t.val);
            return;
        }
        result.append(t.val);
        if (t.left != null) {
            result.append('(');
            helper(t.left);
            result.append(')');
        }

        if (t.right != null) {
            if (t.left == null) result.append("()");
            result.append('(');
            helper(t.right);
            result.append(')');
        }
    }
}
