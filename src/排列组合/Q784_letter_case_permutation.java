package 排列组合;

import java.util.ArrayList;
import java.util.List;

public class Q784_letter_case_permutation {
    private char[] chars;
    private List<String> result = new ArrayList<>();
    private StringBuilder temp = new StringBuilder();

    public List<String> letterCasePermutation(String S) {
        /**
         * 思入: 回溯法: 碰到数字就走一个分支, 碰到字母就走2个分支
         */
        if (S.length() == 0) return result;
        chars = S.toCharArray();
        helper(0);
        return result;
    }

    private void helper(int depth) {
        if (depth == chars.length) {
            result.add(temp.toString());
            return;
        }
        char c = chars[depth];
        if ('0' <= c && c <= '9') {
            temp.append(c);
            helper(depth + 1);
            temp.deleteCharAt(temp.length() - 1);
        } else {
            temp.append(Character.toLowerCase(c));
            helper(depth + 1);
            temp.deleteCharAt(temp.length() - 1);

            temp.append(Character.toUpperCase(c));
            helper(depth + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q784_letter_case_permutation s = new Q784_letter_case_permutation();
        List<String> result = s.letterCasePermutation("a1b2");
        System.out.println(result);

    }


}
