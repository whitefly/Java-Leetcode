package 哈希;

public class Q567_permutation_in_string {
    public boolean checkInclusion(String s1, String s2) {
        /**
         * 思入: 使用字符hash+滑动双指针的思想:
         * 设置 字符hash数组,先统计s1的字符出现频率,每出现一次,对应频率-1
         * 然后扫s2,每出现每个字符时,对应位置+1.
         * 用一个变量count来记录非0的位置,每滑动一次,计算出count的变化值.若某次结束后count变为0,则表示成功匹配
         */
        if (s1.length() > s2.length()) return false;
        int[] hash = new int[128];
        int count = 0;
        for (char c : s1.toCharArray()) {
            hash[c]--;
            if (hash[c] == -1) count++;
        }
        //初始化
        for (int i = 0; i < s1.length(); i++) {
            char c = s2.charAt(i);
            if (hash[c] == -1) count--;
            else if (hash[c] == 0) count++;
            hash[c]++;
        }
        if (count == 0) return true;

        //滑动指针遍历
        int size = s2.length();
        for (int l = 1, r = s1.length(); r < size; l++, r++) {
            //去掉之前的影响
            char oldc = s2.charAt(l - 1);
            hash[oldc]--;
            if (hash[oldc] == 0) count--;
            else if (hash[oldc] == -1) count++;

            //添加现在的影响
            char newc = s2.charAt(r);
            hash[newc]++;
            if (hash[newc] == 0) count--;
            else if (hash[newc] == 1) count++;
            //判断
            if (count == 0) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "eidboooacb";
        Q567_permutation_in_string s = new Q567_permutation_in_string();
        boolean b = s.checkInclusion(s1, s2);
        System.out.println(b);
    }
}
