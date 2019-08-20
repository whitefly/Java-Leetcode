package 双指针;

import 链表.Q2_add_two_numbers;

import java.lang.reflect.Array;
import java.util.*;

public class Q3_longest_substring_without_repeating_characters {

    public static int lengthOfLongestSubstring(String s) {
        /**
         思入1:伪暴力扫描,双指针表示符合要求的.
         复杂度: 时间O(n^2)
         */
        Set<Character> buff = new HashSet<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j >= 0; j--) {
                Character c = s.charAt(j);
                if (buff.contains(c)) {
                    break;
                } else {
                    buff.add(c);
                    result = Math.max(result, i - j + 1);
                }
            }
            buff.clear();
        }
        return result;
    }

    public static int lengthOfLongestSubstring2(String s) {
        /**
         * 思入2: 双指针表示符合要求的字符串,右指针一直右移动,若碰上重复的,对左指针进行紧缩.类似于滑动窗口
         * 若在scan某个点时,我知道左边不同元素的最后位置(包括scan的元素).若scan元素之间出现过,且位置大于L,则需要收紧L,若不大于,则随意
         *
         */
        Map<Character, Integer> buff = new HashMap<>();
        int result = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);

            if (buff.containsKey(temp)) l = Math.max(buff.get(temp) + 1, l);

            buff.put(temp, i);
            result = Math.max(i - l + 1, result);
        }
        return result;
    }

    public static int lengthOfLongestSubstring3(String s) {
        /**
         * 思入3: 在思入2个基础上,用数组来代替Map.
         * 复杂度: 时间O(n),空间O(1)
         */
        int buff[] = new int[128];
        Arrays.fill(buff, -1);
        int result = 0;
        for (int i = 0, l = 0; i < s.length(); i++) {
            char temp = s.charAt(i);

            if (buff[temp] != -1) {
                l = Math.max(buff[temp] + 1, l);
            }
            buff[temp] = i;
            result = Math.max(i - l + 1, result);
        }
        return result;
    }

    public static void main(String args[]) {
        String my = "pwwkew";

        System.out.println(Q3_longest_substring_without_repeating_characters.lengthOfLongestSubstring3(my));

    }
}
