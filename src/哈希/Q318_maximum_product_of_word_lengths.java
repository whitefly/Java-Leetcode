package 哈希;

import java.util.Arrays;

public class Q318_maximum_product_of_word_lengths {
    public int maxProduct(String[] words) {
        /**
         *  思入: 字符hash+暴力扫所有组合. 若不含公共字母,然后 size1*size2
         */
        int result = 0, size = words.length;
        int[] hash = new int[26];
        for (int i = 0; i < size; i++) {
            //字符hash
            Arrays.fill(hash, 0);
            for (char c : words[i].toCharArray()) hash[c - 'a'] += 1;

            for (int j = i + 1; j < size; j++) {
                int multi_size = words[i].length() * words[j].length();
                if (multi_size < result) continue;

                boolean flag = true;
                for (char c : words[j].toCharArray()) {
                    if (hash[c - 'a'] != 0) {
                        flag = false;
                        break;
                    }
                }
                if (flag) result = multi_size;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String[] nums = {"a", "aa", "aaa", "aaaa"};
        Q318_maximum_product_of_word_lengths s = new Q318_maximum_product_of_word_lengths();
        int i = s.maxProduct(nums);
        System.out.println(i);
    }

}
