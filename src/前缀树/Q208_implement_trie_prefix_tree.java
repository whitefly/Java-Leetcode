package 前缀树;

class Trienode {
    boolean end_flag = false;
    Trienode[] children = new Trienode[26];  //用下标index来表示char
}

public class Q208_implement_trie_prefix_tree {

    /**
     * Initialize your data structure here.
     */

    Trienode root;

    public Q208_implement_trie_prefix_tree() {
        root = new Trienode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Trienode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) temp.children[index] = new Trienode();  //转跳时,若不存在,就创建后再转跳

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
        Trienode temp = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (temp.children[index] == null) return false;
            temp = temp.children[index];
        }
        return isprefix || temp.end_flag;
    }
}
