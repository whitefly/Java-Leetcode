package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O38_zi_fu_chuan_de_pai_lie_lcof {
    List<String> result;
    boolean[] gone;

    public String[] permutation(String s) {
        result = new ArrayList<>();
        gone = new boolean[s.length()];
        StringBuilder sb = new StringBuilder();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        helper(chars, 0, sb);
        return result.toArray(new String[0]);
    }

    void helper(char[] chars, int index, StringBuilder sb) {
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (gone[i]) continue;
            if (i > 0 && chars[i - 1] == chars[i] && !gone[i - 1]) continue;
            gone[i] = true;
            sb.append(chars[i]);
            helper(chars, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
            gone[i] = false;
        }
    }

    public static void main(String[] args) {
        O38_zi_fu_chuan_de_pai_lie_lcof s = new O38_zi_fu_chuan_de_pai_lie_lcof();
        String[] abcs = s.permutation("abc");
        System.out.println(Arrays.toString(abcs));
    }
}
