package KMP;

import java.util.Arrays;

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

    public String longestPalindrome2(String s) {
        /*
        dp[i][j]=   如果i==j,则为true , 若i>j,取2种情侣 dp[i+1][j-1]&&s[i]==[j]    i==j
        扩展二维矩阵,若使用反向递归式, 要知道dp[i][j],需要先知道dp[i+1][j-1],即左下方
        所以通过这个确定循环方向
         */
        String result = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                dp[i][j] = (i == j) || (i + 1 == j ? chars[i] == chars[j] : (dp[i + 1][j - 1] && chars[i] == chars[j]));
                if (dp[i][j] && result.length() < (j - i + 1)) result = s.substring(i, j + 1);
            }
            System.out.println(Arrays.toString(dp[i]));
        }
        return result;
    }

    public String longestPalindrome3(String s) {
        /*
        思入: 由于只使用上一层的dp结果,考虑
         */
        String result = "";
        boolean[] dp = new boolean[s.length()];
        char[] chars = s.toCharArray();
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = s.length() - 1; j >= i; j--) {
                dp[j] = (i == j) || (i + 1 == j ? chars[i] == chars[j] : (dp[j - 1] && chars[i] == chars[j]));
                if (dp[j] && result.length() < (j - i + 1)) result = s.substring(i, j + 1);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        String target = "babad";
        Q5_longest_palindromic_substring s = new Q5_longest_palindromic_substring();
        String s1 = s.longestPalindrome2(
                target);

        System.out.println();
        String s2 = s.longestPalindrome3(
                target);

        System.out.println(s1);
        System.out.println(s2);
        System.out.println("你好");

    }
}
