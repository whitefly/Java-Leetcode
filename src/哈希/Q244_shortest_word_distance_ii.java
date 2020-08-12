package 哈希;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q244_shortest_word_distance_ii {
    static class WordDistance {
        Map<String, List<Integer>> map = new HashMap<>();

        public WordDistance(String[] words) {
            for (int i = 0; i < words.length; i++) {
                List<Integer> list;
                if ((list = map.get(words[i])) == null) {
                    list = new ArrayList<>();
                    map.put(words[i], list);
                }
                list.add(i);
            }
        }

        public int shortest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            //双指针
            int p1 = 0, p2 = 0, min = Integer.MAX_VALUE;
            while (p1 < list1.size() && p2 < list2.size()) {
                Integer index1 = list1.get(p1);
                Integer index2 = list2.get(p2);
                if (index1 < index2) {
                    p1++;
                } else {
                    p2++;
                }
                min = Math.min(min, Math.abs(index1 - index2));
            }
            return min;
        }
    }
}
