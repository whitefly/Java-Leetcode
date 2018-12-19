package 递归;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q17_letter_combinations_of_a_phone_number {
    String map[][] = {{"a"}, {"1"},
            {"a", "b", "c"},
            {"d", "e", "f"},
            {"g", "h", "i"},
            {"j", "k", "l"},
            {"m", "n", "o"},
            {"p", "q", "r", "s"},
            {"t", "u", "v"},
            {"w", "x", "y", "z"},
    };


    public List<String> letterCombinations(String digits) {
        /**
         *思入: 递归思想,传入的是余下数字的组合
         */
        if (digits.length() == 0) return new ArrayList<>();
        char num = digits.charAt(0);
        if (digits.length() == 1) return Arrays.asList(map[num - '0']);
        ArrayList<String> now = new ArrayList<>();
        List<String> rest = letterCombinations(digits.substring(1));
        for (String c : map[num - '0']) for (String one : rest) now.add(c + one);

        return now;
    }

    public static void main(String[] args) {
        Q17_letter_combinations_of_a_phone_number s = new Q17_letter_combinations_of_a_phone_number();
        List<String> r = s.letterCombinations("23");
        System.out.println(r);

    }
}
