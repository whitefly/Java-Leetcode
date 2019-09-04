package 数学结论;

public class Q504_base_7 {
    public String convertToBase7(int num) {
            /*
            思入:简单的进制装换
             */
        StringBuilder sb = new StringBuilder();
        boolean negative = num < 0;
        num = Math.abs(num);
        do {
            int i = num % 7;
            sb.append(i);
            num = num / 7;
        } while (num != 0);
        return negative ? "-" + sb.reverse() : sb.reverse().toString();
    }

    public static void main(String[] args) {
        Q504_base_7 s = new Q504_base_7();
        System.out.println(s.convertToBase7(-7));
    }
}
