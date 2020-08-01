package 子序列;

import java.util.*;

public class Q792_number_of_matching_subsequences {
    /**
     * 多子序列的匹配问题
     * 暴力法的优化: hash+二分
     *
     * @param S
     * @param words
     * @return
     */
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, List<Integer>> map = new HashMap<>();
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            List<Integer> orDefault = map.getOrDefault(chars[i], new ArrayList<>());
            orDefault.add(i);
            map.put(chars[i], orDefault);
        }

        //二分查找
        int count = 0;
        for (String item : words) {
            if (check(map, item.toCharArray())) count++;
        }
        return count;
    }

    private boolean check(Map<Character, List<Integer>> map, char[] chars) {
        int pre = -1;
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            List<Integer> integers = map.get(c);
            if (integers == null) return false;
            if (i == 0) {
                pre = integers.get(0);
                continue;
            }
            int i1 = Collections.binarySearch(integers, pre + 1);
            if (i1 >= 0) {
                pre = integers.get(i1);
            } else {
                i1 = -i1 - 1;
                if (i1 < integers.size()) {
                    pre = integers.get(i1);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 消除+桶移动
     * 属于最优解,但是方法不好想
     *
     * @return
     */

    static class Node {
        String word;
        int index;

        public Node(String w, int i) {
            word = w;
            index = i;
        }
    }

    public int numMatchingSubseq2(String S, String[] words) {
        ArrayList<Node>[] map = new ArrayList[26];
        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (String item : words) {
            char c = item.charAt(0);
            map[c - 'a'].add(new Node(item, 0));
        }
        //桶内元素消除+移动
        int count = 0;
        for (char c : S.toCharArray()) {
            ArrayList<Node> bucket = map[c - 'a'];
            int size = bucket.size();
            for (int i = size - 1; i >= 0; i--) {
                Node item = bucket.get(i);
                int next = ++item.index;
                if (item.index == item.word.length()) count++;
                else {
                    //移动
                    ArrayList<Node> other = map[item.word.charAt(next) - 'a'];
                    other.add(item);
                }
                bucket.remove(i);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String S = "rwpddkvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvjubjgloeofnpjqlkdsqvruvabjrikfwronbrdyyjnakstqjac";
        String[] words = {"wpddkvbnn", "lnagtva", "kvbnnuglnagtvamxkqtwhqgwbqgfbvgkwyuqkdwhzudsxvju", "rwpddkvbnnugln", "gloeofnpjqlkdsqvruvabjrikfwronbrdyyj", "vbgeinupkvgmgxeaaiuiyojmoqkahwvbpwugdainxciedbdkos", "mspuhbykmmumtveoighlcgpcapzczomshiblnvhjzqjlfkpina", "rgmliajkiknongrofpugfgajedxicdhxinzjakwnifvxwlokip", "fhepktaipapyrbylskxddypwmuuxyoivcewzrdwwlrlhqwzikq", "qatithxifaaiwyszlkgoljzkkweqkjjzvymedvclfxwcezqebx"};
        Q792_number_of_matching_subsequences s = new Q792_number_of_matching_subsequences();
//        String S = "abbddde";
//        String[] words = {"a", "bb", "acd", "ace", "de"};
        int i = s.numMatchingSubseq2(S, words);
        System.out.println(i);
    }
}
