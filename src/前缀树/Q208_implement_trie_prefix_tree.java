package 前缀树;


public class Q208_implement_trie_prefix_tree {
    static class TrieNode {
        boolean end_flag = false;
        TrieNode[] children = new TrieNode[26];  //用下标index来表示char
    }

    /**
     * Initialize your data structure here.
     */

    TrieNode root;

    public Q208_implement_trie_prefix_tree() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) temp.children[index] = new TrieNode();  //转跳时,若不存在,就创建后再转跳

            temp = temp.children[index];
        }
        temp.end_flag = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        return find(word, false);
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return find(prefix, true);
    }

    private boolean find(String word, boolean isprefix) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return isprefix || temp.end_flag;
    }
}
