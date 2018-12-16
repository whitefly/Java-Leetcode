package 有限状态机;

public class Q8_string_to_integer_atoi {
    int Digit = 0, Blank = 1, Sign = 2, Other = 3, End = 4, T = 98, F = 99;
    //状态转移表
    private int table[][] = {
            {2, 0, 1, F, F},
            {2, F, F, F, F},
            {2, T, T, T, T}
    };

    private int get_element(char c) {
        if ('0' <= c && c <= '9') return Digit;
        else if (c == ' ') return Blank;
        else if (c == '+' || c == '-') return Sign;
        else if (c == '\0') return End;
        else return Other;
    }

    public int myAtoi(String str) {
        /**
         * 之前使用if_else来用条件判断,容易漏掉一些东西.
         * 所以这次采用有限状态机来完成
         */
        String new_str = str + '\0';
        int last_S = 0;
        long result = 0;
        int sign = 1;
        for (char c : new_str.toCharArray()) {
            int e = get_element(c);
            last_S = table[last_S][e];
            //根据不同的状态做判断
            if (last_S == 1 && c == '-') sign = -1;
            if (last_S == 2) {
                result = result * 10 + (c - '0');
                long temp = sign * result;
                if (temp != (int) temp) return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;  //判断是否溢出
            }
            if (last_S == F) return 0;  //非法状态
            if (last_S == T) return sign * (int) result;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q8_string_to_integer_atoi s = new Q8_string_to_integer_atoi();
        String a = " 123323";
        System.out.println(s.myAtoi(a));

    }
}
