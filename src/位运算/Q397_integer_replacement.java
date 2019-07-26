package 位运算;

import java.util.LinkedList;
import java.util.Queue;

public class Q397_integer_replacement {
    public int integerReplacement(int n) {
        /*
        思入: 动态规划+位运算.
        一个数如果是2个幂,那么一定是最速的.通过动态规划慢慢往上面靠即可
        什么时候结束: 碰到2个幂时返回
         */
        return helper(n);
    }

    private int helper(long n) {
        if (n == 1) return 0;
        if ((n & 1) == 0) {
            return helper(n >> 1) + 1; //偶数
        } else {
            return Math.min(helper(n + 1), helper(n - 1)) + 1;
        }
    }


    public static void main(String[] args) {
        Q397_integer_replacement s = new Q397_integer_replacement();
        System.out.println(s.integerReplacement(2147483647));
    }


}
