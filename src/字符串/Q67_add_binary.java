package 字符串;

import java.lang.Math;

public class Q67_add_binary {
    public String addBinary(String a, String b) {
        /**
         * 类似为大数相加,只不过是2进制
         */
        char[] c1 = new StringBuilder(a).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(b).reverse().toString().toCharArray();

        int a_size = a.length(), b_size = b.length();
        int max_size = Math.max(a_size, b_size);

        StringBuilder s = new StringBuilder();
        int carry = 0, temp;
        for (int i = 0; i <= max_size; i++) {
            int num1 = i < a_size ? c1[i] - '0' : 0;
            int num2 = i < b_size ? c2[i] - '0' : 0;
            temp = num1 + num2 + carry;
            carry = temp / 2;
            s.append(temp % 2);
        }
        //反转输出
        String r = s.reverse().toString();
        if (r.startsWith("0")) return r.substring(1);
        return r;
    }

    public static void main(String[] args) {
        Q67_add_binary s = new Q67_add_binary();
        String a = "1010", b = "1011";
        System.out.println(s.addBinary(a, b));
    }
}
