package 哈希;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49_group_anagrams {


    public List<List<String>> groupAnagrams(String[] strs) {
        /**
         * 思入: 字符串hash作为key
         */
        HashMap<String, List<String>> hash = new HashMap<>();
        for (String str : strs) {
            //计算字符hash
            int[] temp = new int[26];
            for (char c : str.toCharArray()) temp[c - 'a'] += 1;
            String key = Arrays.toString(temp);

            //插入
            if (!hash.containsKey(key)) hash.put(key, new ArrayList<>());
            hash.get(key).add(str);
        }

        //组成结果
        return new ArrayList<>(hash.values());
    }

    public static void main(String[] args) {
        String[] nums = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Q49_group_anagrams s = new Q49_group_anagrams();
        List<List<String>> lists = s.groupAnagrams(nums);

        for (List<String> one : lists) System.out.println(one);

        Arrays.asList(1, 2);
    }
}
