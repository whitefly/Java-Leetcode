package 字符串;

public class Q383_ransom_note {
    public boolean canConstruct(String ransomNote, String magazine) {
        /*
        思入: 26个字符数组即可解决
         */
        if (ransomNote.length() > magazine.length()) return false;
        int[] map = new int[26];
        for (char c : magazine.toCharArray()) map[c - 'a']++;
        for (char c : ransomNote.toCharArray()) {
            int temp = --map[c - 'a'];
            if (temp < 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Q383_ransom_note s = new Q383_ransom_note();
        System.out.println(s.canConstruct("a", "b"));
        System.out.println(s.canConstruct("aa", "ab"));
        System.out.println(s.canConstruct("aa", "aab"));

    }
}
