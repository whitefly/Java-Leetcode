package 动态规划;

public class Q467_unique_substrings_in_wraparound_string {
    public int findSubstringInWraproundString(String p) {
        /*
         思入: 动态规划 最长连续子串. dp[i]以i结尾的最长子串.  strLen[b]:表示以b结尾的长度. 若strLen[b]=3, 则有b,ab,zab可以入选(都是以b结尾)
         strLen[b]+strLen[a]是不会重复的.
         所以 sum(steLen)即可
         */
        if (p.length() <= 1) return p.length();
        char[] chars = p.toCharArray();
        int dp = 1, gap;
        int[] strLen = new int[26];
        strLen[chars[0] - 'a']++;
        for (int i = 1; i < chars.length; i++) {
            gap = chars[i] - chars[i - 1];
            if (gap == 1 || gap == -25) {
                dp++;
            } else dp = 1;

            strLen[chars[i] - 'a'] = Math.max(dp, strLen[chars[i] - 'a']);
        }

        int result = 0;
        for (int i : strLen) result += i;  //
        return result;
    }

    public static void main(String[] args) {
        String k = "zab";
        Q467_unique_substrings_in_wraparound_string s = new Q467_unique_substrings_in_wraparound_string();
        System.out.println(s.findSubstringInWraproundString(k));
    }

}
