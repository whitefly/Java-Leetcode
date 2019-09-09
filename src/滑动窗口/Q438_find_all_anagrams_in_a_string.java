package 滑动窗口;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q438_find_all_anagrams_in_a_string {
    public List<Integer> findAnagrams(String s, String p) {
        /*
        思入: 用字符hash来保存字符串的状态  每次滑动一次就比一下字符hash
         */
        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : chars2) map2[c - 'a']++;

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < chars1.length; j++) {
            map1[chars1[j] - 'a']++; //新的加入状态
            if (j >= chars2.length) map1[chars1[j - chars2.length] - 'a']--; //保持窗口规定,左指针右移
            if (Arrays.equals(map1, map2)) result.add(j - chars2.length + 1);
        }
        return result;
    }

    public List<Integer> findAnagrams2(String s, String p) {
        /*
        思入: 如果加入一个多余的字符,就没有必要比较了,绝对不等
         */

        char[] chars1 = s.toCharArray();
        char[] chars2 = p.toCharArray();

        int[] map1 = new int[26];
        int[] map2 = new int[26];
        for (char c : chars2) map2[c - 'a']++;
        int invalidCount = 0;

        List<Integer> result = new ArrayList<>();
        for (int j = 0; j < chars1.length; j++) {
            map1[chars1[j] - 'a']++; //新的加入状态
            if (map2[chars1[j] - 'a'] == 0) invalidCount++;  //新加入的是否为非法字符

            if (j >= chars2.length) {
                int index = chars1[j - chars2.length] - 'a';
                map1[index]--; //保持窗口规定,左指针右移}
                if (map2[index] == 0) invalidCount--;  //左移时,是否减少非法字符
            }
            if (invalidCount == 0 && Arrays.equals(map1, map2)) result.add(j - chars2.length + 1);
        }
        return result;
    }


    public static void main(String[] args) {
        String all = "cbaebabacd";
        String target = "abc";
        Q438_find_all_anagrams_in_a_string s = new Q438_find_all_anagrams_in_a_string();

        System.out.println(s.findAnagrams(all, target));
    }
}
