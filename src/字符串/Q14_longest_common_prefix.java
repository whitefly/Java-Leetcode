package 字符串;

public class Q14_longest_common_prefix {
    private int two_common(String s1, String s2) {
        int min_size = Math.min(s1.length(), s2.length());
        for (int i = 0; i < min_size; i++) if (s1.charAt(i) != s2.charAt(i)) return i - 1;
        return min_size - 1;
    }

    public String longestCommonPrefix(String[] strs) {
        /**
         *  思入: 最长前缀不断迭代即可
         */
        int size = strs.length;
        if (size == 1) return strs[0];
        if (size == 0) return "";
        String last_pre = strs[0];
        for (int i = 1; i < size; i++) {
            int index = two_common(last_pre, strs[i]);
            if (index == -1) return "";
            last_pre = last_pre.substring(0, index + 1);
        }
        return last_pre;
    }

    public static void main(String[] args) {
        String[] fucker = {"dog", "racecar", "car"};
        Q14_longest_common_prefix s = new Q14_longest_common_prefix();
        String s1 = s.longestCommonPrefix(fucker);
        System.out.println(s1);

    }
}
