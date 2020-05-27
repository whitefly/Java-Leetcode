package 剑指Offer;

public class O50_di_yi_ge_zhi_chu_xian_yi_ci_de_zi_fu_lcof {
    public char firstUniqChar(String s) {
        //扫二遍,一遍counter,一遍找第一个
        int[] counter = new int[128];
        char[] chars = s.toCharArray();
        for (char c : chars) counter[c]++;
        for (char c : chars) {
            if (counter[c] == 1) return c;
        }
        return ' ';
    }
}
