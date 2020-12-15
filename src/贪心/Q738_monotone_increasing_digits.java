package 贪心;

public class Q738_monotone_increasing_digits {
    public int monotoneIncreasingDigits(int N) {
        //贪心,从后向前寻找找flag位
        char[] chars = (N + "").toCharArray();
        int split = -1;
        for (int i = chars.length - 1; i > 0; i--) {
            if (chars[i - 1] > chars[i]) {
                chars[i - 1] -= 1;
                split = i - 1;
            }
        }
        //开始设置9
        if (split != -1) for (int i = split + 1; i < chars.length; i++) chars[i] = '9';

        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        int N = 1234;
        Q738_monotone_increasing_digits solution = new Q738_monotone_increasing_digits();
        int i = solution.monotoneIncreasingDigits(N);

        System.out.println(i);
    }
}
