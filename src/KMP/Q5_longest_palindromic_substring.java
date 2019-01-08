package KMP;

public class Q5_longest_palindromic_substring {
    public String longestPalindrome(String s) {
        /**
         * 思入1: 设置一个镜面指针, 沿着镜面左右移动.需要考虑奇偶.
         * 奇偶验证的代码比较相似,可以考虑凡在一起
         */
        if (s.length() == 0) return "";
        int size = s.length();
        int max_size = 1;
        String result = s.substring(0, 1);
        for (int mirror_index = 0; mirror_index < size; mirror_index++) {
            //奇数验证
            for (int i = 0; i < size; i++) {
                int index1 = mirror_index - i, index2 = mirror_index + i;
                if (index1 < 0 || index2 >= size) break;  //不符合,后面不用看了
                if (s.charAt(index1) != s.charAt(index2)) break;
                if ((2 * i + 1) >= max_size) {
                    max_size = 2 * i + 1;
                    result = s.substring(index1, index2 + 1);
                }
            }
            //偶数验证
            for (int i = 0; i < size; i++) {
                int index1 = mirror_index - i, index2 = mirror_index + i + 1;
                if (index1 < 0 || index2 >= size) break;
                if (s.charAt(index1) != s.charAt(index2)) break;
                if ((2 * i + 2) > max_size) {
                    max_size = 2 * i + 2;
                    result = s.substring(index1, index2 + 1);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q5_longest_palindromic_substring s = new Q5_longest_palindromic_substring();
        String s1 = s.longestPalindrome(
                "abcda");
        System.out.println(s1);

    }
}
