package 字符串;

import javax.lang.model.util.SimpleAnnotationValueVisitor6;

public class Q392_is_subsequence {
    public boolean isSubsequence(String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "axc", t = "ahbgdc";
        Q392_is_subsequence solver = new Q392_is_subsequence();
        System.out.println(solver.isSubsequence(s, t));
    }
}
