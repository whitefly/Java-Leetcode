package 哈希;

import java.util.Arrays;

public class Q242_valid_anagram {
    public boolean isAnagram(String s, String t) {
        /**
         *  思入: 数量固定字母key的hash,用数组下标来作为ascii的key
         */
        int size1 = s.length(), size2 = t.length();
        if (size1 != size2) return false;

        int map[] = new int[128];
        for (int i = 0; i < size1; i++) {
            map[s.charAt(i)]++;
            map[t.charAt(i)]--;
        }
        for (int i : map) if (i != 0) return false;
        return true;
    }


}
