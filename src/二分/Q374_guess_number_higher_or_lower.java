package 二分;

public class Q374_guess_number_higher_or_lower {
    static int pick = 6;

    int guess(int num) {
        if (pick == num) return 0;
        return (num - pick > 0) ? 1 : -1;
    }

    public int guessNumber(int n) {
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int flag = guess(mid);
            if (flag == 0) return mid;
            else if (flag == -1) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q374_guess_number_higher_or_lower s = new Q374_guess_number_higher_or_lower();
        int i = s.guessNumber(10);
        System.out.println(i);
    }
}
