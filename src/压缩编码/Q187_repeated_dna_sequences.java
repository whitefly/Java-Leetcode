package 压缩编码;

import java.util.*;

public class Q187_repeated_dna_sequences {
    /*
    思入: 10个连续字符作为key,由于AGCT都ascii码都固定
    A: 1000001
    G: 1000111
    C: 1000011
    T: 1010100
    只需要3位就可以完全区分出 4个字符. 10个字符只需要10*3=30个二进制(0-29-> 012,456,来作为key). 所以完全可以用一个int来存储作为唯一的key
     */
    public List<String> findRepeatedDnaSequences(String s) {
        /*
        不使用压缩,直接以10个字符串作为key来统计频率
         */
        Map<String, Integer> counter = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (int i = 9; i < s.length(); i++) {
            String key = s.substring(i - 9, i + 1);
            int f = counter.getOrDefault(key, 0);
            if (f == 1) result.add(key);
            counter.put(key, ++f);
        }
        return result;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        /*
        压缩子串为一个int
         */
        Map<Integer, Integer> counter = new HashMap<>();
        char[] chars = s.toCharArray();
        //滑动指针
        List<String> result = new ArrayList<>();
        int key = 0;
        for (int i = 0; i < s.length(); i++) {
            key = ((key << 3) & 0x3ffffff8) | (chars[i] & 0x7);  //key就是这个int
            int f = counter.getOrDefault(key, 0);
            if (f == 1) result.add(s.substring(i - 9, i + 1));
            counter.put(key, ++f);
        }
        return result;
    }

    public static void main(String[] args) {
        String str = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
//        String str = "A";
        Q187_repeated_dna_sequences s = new Q187_repeated_dna_sequences();
        List<String> repeatedDnaSequences = s.findRepeatedDnaSequences2(str);
        System.out.println(repeatedDnaSequences);

    }
}
