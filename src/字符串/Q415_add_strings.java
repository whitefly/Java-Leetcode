package 字符串;

public class Q415_add_strings {
    public String addStrings(String num1, String num2) {
        /**
         *思入: 大数加法,和Q67题几乎没有任何区别, 较短的链补0到相同长度
         */
        char[] c1 = new StringBuilder(num1).reverse().toString().toCharArray();
        char[] c2 = new StringBuilder(num2).reverse().toString().toCharArray();

        int a_size = num1.length(), b_size = num2.length();
        int max_size = Math.max(a_size, b_size);

        StringBuilder s = new StringBuilder();
        int carry = 0, temp;
        for (int i = 0; i <= max_size; i++) {
            int a = i < a_size ? c1[i] - '0' : 0;
            int b = i < b_size ? c2[i] - '0' : 0;
            temp = a + b + carry;
            carry = temp / 10;
            s.append(temp % 10);
        }
        //反转输出
        String r = s.reverse().toString();
        if (r.startsWith("0")) return r.substring(1);
        return r;
    }

    public static void main(String[] args) {
        Q415_add_strings s = new Q415_add_strings();
        String a = "1010", b = "1011";
        System.out.println(s.addStrings(a, b));
    }
}
