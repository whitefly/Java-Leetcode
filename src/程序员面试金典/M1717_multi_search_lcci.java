package 程序员面试金典;

import java.util.*;

public class M1717_multi_search_lcci {
    static class ACNode {
        Map<Character, ACNode> children = new HashMap<>();
        ACNode fail;
        Set<Integer> lens = new HashSet<>();
    }

    public static void insert(ACNode root, String word) {
        char[] chars = word.toCharArray();
        ACNode temp = root;
        for (char c : chars) {
            if (!temp.children.containsKey(c)) {
                temp.children.put(c, new ACNode());
            }
            temp = temp.children.get(c);
        }
        temp.lens.add(chars.length);
    }

    public static Map<String, List<Integer>> query(ACNode root, String targetWord) {
        //暂时通过
        Map<String, List<Integer>> rnt = new HashMap<>();
        ACNode temp = root;
        char[] chars = targetWord.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            //转跳fail
            while (!temp.children.containsKey(c) && temp.fail != null) {
                temp = temp.fail;
            }

            if (temp.children.containsKey(c)) {
                temp = temp.children.get(c);
            } else {
                //temp已经到root
                continue;
            }

            for (Integer len : temp.lens) {
                int startIndex = i - len + 1;
                String kv = targetWord.substring(startIndex, i + 1);
                List<Integer> integers = rnt.getOrDefault(kv, new ArrayList<>());
                integers.add(startIndex);
                rnt.put(kv, integers);
            }
        }
        return rnt;
    }

    public static void buildFail(ACNode root) {
        Queue<ACNode> queue = new LinkedList<>();

        //第二层的设置为root
        for (ACNode second : root.children.values()) {
            second.fail = root;
            queue.offer(second);
        }

        //层次遍历
        while (!queue.isEmpty()) {
            //取出父节点
            ACNode father = queue.poll();

            for (Map.Entry<Character, ACNode> child : father.children.entrySet()) {
                ACNode current = child.getValue();
                Character c = child.getKey();
                ACNode faFail = father.fail;

                //迭代回溯
                while (faFail != null && !faFail.children.containsKey(c)) {
                    faFail = faFail.fail;
                }

                //找到最后的fail
                current.fail = (faFail == null) ? root : faFail.children.get(c);

                //并入faFail含有的内容
                if (!current.fail.lens.isEmpty()) {
                    current.lens.addAll(current.fail.lens);
                }

                queue.offer(current);
            }
        }
    }


    public int[][] multiSearch(String big, String[] smalls) {
        ACNode root = new ACNode();
        for (String word : smalls) {
            insert(root, word);
        }
        buildFail(root);
        Map<String, List<Integer>> query = query(root, big);

        int[][] result = new int[smalls.length][];
        for (int i = 0; i < result.length; i++) {
            List<Integer> position = query.getOrDefault(smalls[i], new ArrayList<>());
            result[i] = new int[position.size()];
            for (int j = 0; j < position.size(); j++) {
                result[i][j] = position.get(j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        M1717_multi_search_lcci m1717_multi_search_lcci = new M1717_multi_search_lcci();
        String[] smalls = {"is", "ppi", "hi", "sis", "i", "ssippi"};
        int[][] mississippis = m1717_multi_search_lcci.multiSearch("mississippi", smalls);
        for (int[] rnt : mississippis) {
            System.out.println(Arrays.toString(rnt));
        }
    }
}
