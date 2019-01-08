package 哈希;

import java.util.Arrays;
import java.util.Comparator;

public class Q451_sort_characters_by_frequency {
    class tuple {
        char key;
        int count = 0;

        tuple(char c) {
            key = c;
        }
    }

    public String frequencySort(String s) {
        /**
         * 思入: 设定一个class (a,12)  遍历,然后排序, 重新生成结果字符串
         */
        int total = 128;
        tuple[] fucker = new tuple[total];
        for (int i = 0; i < total; i++) fucker[i] = new tuple((char) i);
        for (char c : s.toCharArray()) fucker[c].count++;

        //排序
        Arrays.sort(fucker, new Comparator<tuple>() {
            @Override
            public int compare(tuple o1, tuple o2) {
                return o2.count - o1.count;
            }
        });

        //重新生成结果字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < total; i++) {
            int size = fucker[i].count;
            if (size != 0) {
                char key = fucker[i].key;
                for (int j = 0; j < size; j++) result.append(key);
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
        Q451_sort_characters_by_frequency s = new Q451_sort_characters_by_frequency();
        String tree = s.frequencySort("Aabb");
        System.out.println(tree);

    }
}
