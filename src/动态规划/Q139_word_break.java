package 动态规划;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q139_word_break {
    private Map<String, Boolean> dp = new HashMap<>();

    public boolean wordBreak(String s, List<String> wordDict) {
        /**
         * 动态规划的递归版
         */
        if (dp.containsKey(s)) return dp.get(s);
        boolean result = false;
        if (s.isEmpty()) {
            result = true;
        } else {
            for (String prefix : wordDict) {
                if (s.startsWith(prefix)) result |= wordBreak(s.substring(prefix.length()), wordDict);
            }
        }
        dp.put(s, result);
        return result;
    }

    public static void main(String[] args) {
        String s = "catsandog";
        List<String> wordDict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        Q139_word_break fuck = new Q139_word_break();
        System.out.println(fuck.wordBreak(s, wordDict));
    }

}
