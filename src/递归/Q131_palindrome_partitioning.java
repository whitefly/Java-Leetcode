package 递归;

import java.util.*;

public class Q131_palindrome_partitioning {

    public List<List<String>> partition(String s) {
        /**
         * 思入: 递归,将aab 分为2分部.前一部分为当前部分,后一个部分用于递归
         */
        List<List<String>> result = new LinkedList<>();
        if (s.equals("")) {
            //终止剪枝
            result.add(new LinkedList<>());
        } else {
            //拆分
            for (int i = 0; i < s.length(); i++) {
                String part1 = s.substring(0, i + 1);
                if (check(part1)) {
                    List<List<String>> rest = partition(s.substring(i + 1));
                    //插入最前面
                    for (List<String> item : rest) {
                        item.add(0, part1);
                        result.add(item);
                    }
                }
            }
        }
        return result;
    }


    private boolean check(String subStr) {
        char[] chars = subStr.toCharArray();
        int l = 0, r = subStr.length() - 1;
        while (l <= r) if (chars[l++] != chars[r--]) return false;
        return true;
    }

    public static void main(String[] args) {
        String str = "fff";
        Q131_palindrome_partitioning s = new Q131_palindrome_partitioning();
        List<List<String>> partition = s.partition(str);
        for (List<String> item : partition) {
            System.out.println(item);
        }
    }
}
