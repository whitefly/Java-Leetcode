package 哈希;

public class Q243_shortest_word_distance {
    public int shortestDistance(String[] words, String word1, String word2) {
        //扫描时,记录2个单词出现的最近位置,当时可能最近的距离,肯定是左边最近的
        int p1 = -1;
        int p2 = -1;
        int rnt = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                p1 = i;
                if (p2 >= 0) rnt = Math.min(p1 - p2, rnt);
            } else if (words[i].equals(word2)) {
                p2 = i;
                if (p1 >= 0) rnt = Math.min(p2 - p1, rnt);
            }
        }
        return rnt;
    }
}
