package 字符串距离;

public class Q161_one_edit_distance {
    public boolean isOneEditDistance(String s, String t) {
        //默认len(s)<=len(t)
        // 若s和t相同,则一旦出现s[i]不一样,则[i+1:]都要求一样
        // 若s比t少一个,则一旦出现s[i]不一样,则s[i:] 和 t[i+1:]要求是一样的
        if (Math.abs(s.length() - t.length()) > 1) return false;
        if (s.length() > t.length()) return isOneEditDistance(t, s);

        char[] chars1 = s.toCharArray();
        char[] chars2 = t.toCharArray();

        if (chars1.length == chars2.length) {
            for (int i = 0; i < chars1.length; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return isSame(chars1, i + 1, chars2, i + 1);
                }
            }
            return false;
        } else {
            for (int i = 0; i < chars1.length; i++) {
                if (s.charAt(i) != t.charAt(i)) {
                    return isSame(chars1, i, chars2, i + 1);
                }
            }
            return true;
        }
    }

    public boolean isSame(char[] chars1, int l1, char[] chars2, int l2) {
        for (int i = l1, j = l2; i < chars1.length; i++, j++) {
            if (chars1[i] != chars2[j]) return false;
        }
        return true;
    }
}
