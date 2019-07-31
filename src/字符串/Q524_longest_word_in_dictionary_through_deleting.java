package 字符串;

import java.util.Arrays;
import java.util.List;

public class Q524_longest_word_in_dictionary_through_deleting {
    private char[] chars;

    public String findLongestWord(String s, List<String> d) {
        /*
        思入: 设定一个返回布尔类型的单个词的判定函数.
        字典序最小,可以先对字符串进行排序(长,字典序)
         */
        this.chars = s.toCharArray();
        d.sort((o1, o2) -> {
            int gap = o2.length() - o1.length();
            return gap == 0 ? o1.compareTo(o2) : gap;
        });
        for (String test : d) if (check(test)) return test;
        return "";
    }

    public boolean check(String test) {
        int position = 0;
        for (int scan = 0; scan < chars.length; scan++) {
            if (chars[scan] == test.charAt(position)) position++;
            if (position == test.length()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s = "abpcplea";
        List<String> d = Arrays.asList("ale", "apple", "monkey", "plea");
//        List<String> d = Arrays.asList("ale","apple","monkey","plea");
        Q524_longest_word_in_dictionary_through_deleting solver = new Q524_longest_word_in_dictionary_through_deleting();
        System.out.println(solver.findLongestWord(s, d));

    }
}
