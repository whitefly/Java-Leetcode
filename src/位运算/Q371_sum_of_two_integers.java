package 位运算;

public class Q371_sum_of_two_integers {
    public int getSum(int a, int b) {
        /**
         *思入: 计算机组成原理的位运算.  原位运算结果(异或)+ 进位运算结果(交,左移动1位), 直到没有任何进位运算,循环终止.
         */
        int carry, temp, next;
        do {
            carry = (a & b) << 1;
            temp = a ^ b;

            a = carry;
            b = temp;
            next = carry + temp;
        } while (carry != 0);
        return next;
    }

    public static void main(String[] args) {
        Q371_sum_of_two_integers s = new Q371_sum_of_two_integers();
        System.out.println(s.getSum(-2, 3));

    }
}
