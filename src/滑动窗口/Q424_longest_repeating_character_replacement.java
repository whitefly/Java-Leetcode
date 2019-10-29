package 滑动窗口;

public class Q424_longest_repeating_character_replacement {
    public int characterReplacement(String s, int k) {
        /*
        满足条件: 可以使用k次替换,将所有元素替换成频数最多的元素一毛一样.

        思如: 滑动窗口,2个指针所包含的位置元素,要求使用k次替换后,和包含中的频数最多的元素一样
        若右边指针右移动后,使用k次无法满足要求,则开始收缩左指针,直到满足.
        右指针移动一次,就记录收敛后的结果

        坑点: 左指针收缩过程中,频数最多的元素一样可能会变化
         */
        int[] map = new int[26];
        int result = 0;
        for (int L = 0, R = 0; R < s.length(); R++) {
            map[s.charAt(R) - 'A']++;
            while (!valid(k, map, R - L + 1)) {
                //若不符合,开始收缩
                map[s.charAt(L++) - 'A']--;
            }
            result = Math.max(result, R - L + 1);
        }
        return result;
    }

    private boolean valid(int k, int[] map, int all) {
        return all - getMax(map) <= k;
    }

    private int getMax(int[] map) {
        //收缩过程中,最大频率数会变化,所以之间暴力计算出来了
        int rnt = 0;
        for (int count : map) rnt = Math.max(rnt, count);
        return rnt;
    }

    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        Q424_longest_repeating_character_replacement solver = new Q424_longest_repeating_character_replacement();
        int i = solver.characterReplacement(s, k);
        System.out.println(i);

    }

}
