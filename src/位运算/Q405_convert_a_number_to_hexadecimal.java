package 位运算;

public class Q405_convert_a_number_to_hexadecimal {
    private final static char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public String toHex(int num) {
        /*
        思入: 每次都取左4位
         */
        if (num == 0) return "0";
        int mark = 0xf0000000;
        StringBuilder result = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < 8; i++, num <<= 4) {
            char hex = map[(num & mark) >>> 28];
            if (hex == '0' && !flag) continue;
            flag = true;
            result.append(hex);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Q405_convert_a_number_to_hexadecimal s = new Q405_convert_a_number_to_hexadecimal();
        System.out.println(s.toHex(-1));
    }
}
