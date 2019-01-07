package 哈希;

public class Q387_first_unique_character_in_a_string {
    public int firstUniqChar(String s) {
        /**
         * 思入: 使用数组(26个)来存储频率,找到第一个为1的
         */
        int[] hash = new int[26];
        for (char c : s.toCharArray()) hash[c - 'a'] += 1;
        for (int i = 0; i < s.length(); i++) if (hash[s.charAt(i) - 'a'] == 1) return i;
        return -1;
    }

    public static void main(String[] args) {
        Q387_first_unique_character_in_a_string s = new Q387_first_unique_character_in_a_string();
        System.out.println(s.firstUniqChar("loveleetcode"));
    }


}
