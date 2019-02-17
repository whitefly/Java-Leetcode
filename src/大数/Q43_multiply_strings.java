package 大数;

import java.util.Arrays;

public class Q43_multiply_strings {
    public String multiply(String num1, String num2) {
        /**
         * 字符串转数字,
         *思入: 数组每个元素先存2个数字成绩之和,然后进行规整化(即转为10进制),然后反转字符串
         *
         */
        if (num1.equals("0") || num2.equals("0")) return "0";
        // 加速
        if (num1.equals("1")) return num2;
        if (num2.equals("1")) return num1;

        //估计大致位数
        int num1_size = num1.length(), num2_size = num2.length();
        int[] result = new int[num1_size * num2_size + 2];  //---> 从小到大
        Arrays.fill(result, 0);
        // 无脑相加到特定位置
        int n1, n2;
        for (int i = num1_size - 1; i >= 0; i--) {
            n1 = num1.charAt(i) - '0';
            for (int j = num2_size - 1; j >= 0; j--) {
                //加入特定的位置
                n2 = num2.charAt(j) - '0';
                int position = (num1_size - 1 - i) + (num2_size - 1 - j);
                result[position] += n1 * n2;
            }
        }
        // 规整化
        int last_index = num1_size + num2_size - 1;
        int carry = 0, temp;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i <= last_index; i++) {
            temp = result[i] + carry;
            carry = temp / 10;
            res.append(temp % 10);
        }
        //反转字符串,去掉0
        String s = res.reverse().toString();
        System.out.println(s);
        if (s.startsWith("0"))
            return s.substring(1);
        return s;
    }

    public static void main(String[] args) {
        Q43_multiply_strings s = new Q43_multiply_strings();
        String l = s.multiply("99", "99");
        System.out.println(l);
    }
}
