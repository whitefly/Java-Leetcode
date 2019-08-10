package 前缀树;

public class Q677_map_sum_pairs {
    static class TrieNode {
        int val = 0;  //当前值
        int sum = 0;   //子树的总和
        boolean end_flag = false;
        TrieNode[] children = new TrieNode[26];  //用下标index来表示char
    }


    static class MapSum {
        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            insertHelper(key.toCharArray(), 0, root, val);
        }

        private int insertHelper(char[] key, int index, TrieNode tempRoot, int val) {
            if (key.length == index) {
                tempRoot.end_flag = true;
                int temp = val - tempRoot.val;
                tempRoot.sum += temp;
                tempRoot.val = val;
                return temp;
            }
            int sub = key[index] - 'a';
            if (tempRoot.children[sub] == null) tempRoot.children[sub] = new TrieNode();
            int delta = insertHelper(key, index + 1, tempRoot.children[sub], val);
            tempRoot.sum += delta;
            return delta;
        }

        public int sum(String prefix) {
            TrieNode temp = root;
            for (char c : prefix.toCharArray()) {
                if (temp.children[c - 'a'] == null) return 0;
                temp = temp.children[c - 'a'];
            }
            return temp.sum;
        }
    }

    public static void main(String[] args) {
        MapSum s = new MapSum();
//        s.insert("apple", 3);
//        System.out.println(s.sum("ap"));
//        s.insert("app", 2);
//        System.out.println(s.sum("ap"));

        s.insert("a", 3);
        System.out.println(s.sum("ap"));
        s.insert("b", 2);
        System.out.println(s.sum("a"));


    }
}
