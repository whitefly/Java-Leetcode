package 哈希;

import java.util.Arrays;
import java.util.Comparator;

public class Q748_shortest_completing_word {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));

        String s = licensePlate.toLowerCase();
        int count = 0;
        int[] map = new int[26];
        for (char c : s.toCharArray()) {
            int temp = c - 'a';
            if (temp >= 0 && temp < 26) {
                if (map[c - 'a']++ == 0) count++;
            }
        }

        for (String item : words) {
            if (check(item, map, count)) return item;
        }
        return null;
    }

    private boolean check(String sample, int[] target, int count) {
        if (sample.length() < count) return false;
        int[] copy = Arrays.copyOf(target, target.length);
        for (char c : sample.toCharArray()) {
            if (--copy[c - 'a'] == 0) count--;
        }
        return count == 0;
    }


    public static void main(String[] args) {
        String licensePlate = "1s3 456";
        String[] words = {"looks", "pest", "stew", "show"};
        Q748_shortest_completing_word solver = new Q748_shortest_completing_word();
        String result = solver.shortestCompletingWord(licensePlate, words);
        System.out.println(result);
    }

}
