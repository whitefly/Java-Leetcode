package 动态规划;

public class Q357_count_numbers_with_unique_digits {

    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 10;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + 9 * A(9, i - 1);
        }
        return dp[n];
    }

    private int A(int a, int b) {
        if (b == 0) return 0;
        int result = 1;
        for (int i = 0; i < b; i++) {
            result *= a--;
        }
        return result;
    }

    public static void main(String[] args) {
        Q357_count_numbers_with_unique_digits s = new Q357_count_numbers_with_unique_digits();
        System.out.println(s.countNumbersWithUniqueDigits(3));
    }
}
