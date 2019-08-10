package 前缀树;

public class Q211_add_and_search_word_data_structure_design {
    static class TrieNode {
        boolean end_flag = false;
        TrieNode[] children = new TrieNode[26];  //用下标index来表示char
    }

    static class WordDictionary {
        /**
         * Initialize your data structure here.
         */
        private TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (temp.children[index] == null) temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }
            temp.end_flag = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return searchHelper(word.toCharArray(), 0, root);
        }

        private boolean searchHelper(char[] chars, int index, TrieNode root) {
            if (root == null) return false;
            if (index == chars.length) return root.end_flag;

            char c = chars[index];
            if (c != '.') return searchHelper(chars, index + 1, root.children[c - 'a']);

            boolean result = false;
            for (int i = 0; i < 26 && !result; i++) result = searchHelper(chars, index + 1, root.children[i]);
            return result;
        }
    }

    public static void main(String[] args) {
        WordDictionary s = new WordDictionary();
//        s.addWord("bad");
//        s.addWord("dad");
//        s.addWord("mad");
        System.out.println(s.search("pad"));
        System.out.println(s.search("bad"));
        System.out.println(s.search(".ad"));
        System.out.println(s.search("b.."));
    }
}
