package 动态规划;

public class Q91_decode_ways {
    public int numDecodings(String s) {
        /*
        思入: 动态规划
        dp[i] : i字符结尾的解放方法总数
        状态转移方程:  dp[i] = dp[i-1]  (单数字)+  dp[i-2] (双数字在26之内)
         */
        int step2 = 0, step1 = 0;
        for (int i = 0; i < s.length(); i++) {
            int temp = 0;

            if ((s.charAt(i) - '0') != 0) temp += Math.max(1, step1);
            if (i != 0) {
                int num = (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0';
                if (10 <= num&& num <= 26) temp += Math.max(1, step2);
            }
            if (temp == 0) return 0;
            step2 = step1;
            step1 = temp;
        }
        return step1;
    }


    public static void main(String[] args) {
        String target = "101";
        Q91_decode_ways solver = new Q91_decode_ways();
        System.out.println(solver.numDecodings(target));
    }
}
