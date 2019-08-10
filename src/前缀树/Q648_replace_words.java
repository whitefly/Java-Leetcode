package 前缀树;

import java.util.Arrays;
import java.util.List;

public class Q648_replace_words {
    /*
    思入:字典树判断是否为前缀
     */
    static class TrieNode {
        boolean end_flag = false;
        TrieNode[] children = new TrieNode[26];  //用下标index来表示char
    }

    /**
     * Initialize your data structure here.
     */

    TrieNode root;


    /**
     * Inserts a word into the trie.
     */
    private void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) temp.children[index] = new TrieNode();  //转跳时,若不存在,就创建后再转跳
            temp = temp.children[index];
        }
        temp.end_flag = true;
    }

    private String findPrefix(String word) {
        TrieNode temp = root;
        StringBuilder result = new StringBuilder();
        for (char c : word.toCharArray()) {
            result.append(c);
            TrieNode tempRoot = temp.children[c - 'a'];
            if (tempRoot == null) return word;
            if (tempRoot.end_flag) return result.toString();
            temp = tempRoot;
        }
        return word;
    }

    public String replaceWords(List<String> dict, String sentence) {
        root = new TrieNode();
        String[] Strings = sentence.split(" ");
        for (String item : dict) insert(item);
        for (int i = 0; i < Strings.length; i++) Strings[i] = findPrefix(Strings[i]);
        return String.join(" ", Strings);
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        Q648_replace_words s = new Q648_replace_words();
        System.out.println(s.replaceWords(dict, sentence));
    }
}
