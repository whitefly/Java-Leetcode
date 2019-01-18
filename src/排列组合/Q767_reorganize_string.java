package 排列组合;

import java.util.Arrays;

public class Q767_reorganize_string {
    class Pair implements Comparable<Pair> {
        char c;
        int count = 0;

        Pair(char c) {
            this.c = c;
        }

        void plus() {
            count++;
        }


        @Override
        public int compareTo(Pair o) {
            return o.count - count;
        }
    }

    public String reorganizeString(String S) {
        /**
         * 思入:  同类不相邻问题的通用解_抽屉原理, 若最大种类的数量 <= (其他数量和+1),则可以构成不相邻组合
         */
        int size = S.length();
        Pair[] hash = new Pair[26];
        for (int i = 0; i < 26; i++) hash[i] = new Pair((char) (i + 'a'));
        for (char c : S.toCharArray()) hash[c - 'a'].plus();
        //排序
        Arrays.sort(hash);
        if (2 * hash[0].count - 1 > size) return "";
        // 由频数大到小排列,贪心法填充不相邻的数(此法不可行,比如aaaabbbcc,最后的cc会连在一起)
        char[] r = new char[size];
        for (Pair p : hash) {
            if (p.count == 0) continue;
            char c = p.c;
            int count = p.count;
            for (int j = 0; count > 0 && j < size; j++) {
                if (j != 0 && r[j - 1] == c) continue;
                if (r[j] != '\0') continue;
                r[j] = c;
                count--;
            }
        }
        return String.valueOf(r);
    }

    public static void main(String[] args) {
        String str = "asdasdasdas";
        Q767_reorganize_string s = new Q767_reorganize_string();
        System.out.println(s.reorganizeString(str));
    }
}
