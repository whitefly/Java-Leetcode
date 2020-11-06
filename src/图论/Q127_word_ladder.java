package 图论;


import java.util.*;

public class Q127_word_ladder {
    Map<String, Integer> mapping = new HashMap<>();
    List<List<Integer>> graph = new ArrayList<>();
    int accId = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        //邻接表表示图
        for (String word : wordList) addEdge(word);
        if (!mapping.containsKey(endWord)) return 0;
        addEdge(beginWord);

        //初始化所有的距离
        int[] d = new int[mapping.size()];
        Arrays.fill(d, Integer.MAX_VALUE);

        //起始点为beginWord
        Queue<Integer> Q = new LinkedList<>();
        Q.add(mapping.get(beginWord));
        int beginId = mapping.get(beginWord);
        int endId = mapping.get(endWord);
        d[beginId] = 0;

        //广度遍历
        while (!Q.isEmpty()) {
            int tempId = Q.poll();
            int tempD = d[tempId];
            if (tempId == endId) return tempD / 2 + 1;

            for (int next : graph.get(tempId)) {
                if (d[next] == Integer.MAX_VALUE) {
                    d[next] = tempD + 1;
                    Q.offer(next);
                }
            }
        }

        //无法联通到endWord
        return 0;
    }

    private void addEdge(String word) {
        //每加入一个图,自动生成为fake节点 hit -> *it,h*t,hi*
        addWord(word);

        //优化建图,引入fake节点  原来图hit -> hot   变为  hit->h*t->hot
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            chars[i] = '*';
            String fake = new String(chars);
            addWord(fake);

            int id1 = mapping.get(word);
            int id2 = mapping.get(fake);
            graph.get(id1).add(id2);
            graph.get(id2).add(id1);

            chars[i] = c;
        }
    }


    private void addWord(String word) {
        //在图中加一个list
        if (!mapping.containsKey(word)) {
            mapping.put(word, accId++);
            graph.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        String beginWord = "hot";
        String endWord = "dog";
        List<String> wordList = Arrays.asList("hot", "dog");
        Q127_word_ladder solver = new Q127_word_ladder();
        int i = solver.ladderLength(beginWord, endWord, wordList);

        System.out.println(i);
    }
}
