package 剑指Offer;

public class O26_shu_de_zi_jie_gou_lcof {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //-----------------------没看答案的想法-----------------
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //设置flag是用来判断父节点是否进行匹配过,若匹配过,则子节点需要进行完全匹配.若没有匹配过,则随意
        if (B == null) return false;
        return helper(A, B, false);

    }

    boolean helper(TreeNode A, TreeNode B, boolean flag) {
        if (B == null) return true;
        if (flag) {
            //若有传承,则必须一致
            return A != null && A.val == B.val && helper(A.left, B.left, true) && helper(A.right, B.right, true);
        } else {
            //若没有传承,往下分化为有传承或者没有传承
            if (A == null) return false;
            boolean result = false;
            if (A.val == B.val) result = helper(A.left, B.left, true) && helper(A.right, B.right, true);
            return result || helper(A.left, B, false) || helper(A.right, B, false);
        }
    }

    // -----------------看完答案后的简化写法-----------------
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null) return false;
        if (A == null) return false;
        return helper2(A, B) || isSubStructure2(A.left, B) || isSubStructure2(A.right, B);
    }

    boolean helper2(TreeNode A, TreeNode B) {
        //helper2从A,B开始匹配的子树
        if (B == null) return true;
        return A != null && A.val == B.val && helper2(A.left, B.left) && helper2(A.right, B.right);
    }

    // ---------- 判断是否为子树的序列化写法-------------------
    public boolean isSubStructure3(TreeNode A, TreeNode B) {
        //前序匹配, 这个方法用于找到完全相同的子树(不是子结构)
        if ((A != null && B == null) || (A == null && B != null)) return false;
        StringBuilder sb1 = preWalk(A, new StringBuilder());
        StringBuilder sb2 = preWalk(B, new StringBuilder());
        System.out.println();
        return sb1.toString().contains(sb2);

    }

    private StringBuilder preWalk(TreeNode A, StringBuilder sb) {
        if (A == null) {
            sb.append("x-");
        } else {
            sb.append(A.val).append("-");
            preWalk(A.left, sb);
            preWalk(A.right, sb);
        }
        return sb;
    }
}
