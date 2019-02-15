package 二分;

import java.util.Arrays;

public class Q875_koko_eating_bananas {
    public int minEatingSpeed(int[] piles, int H) {
        int L = 1, R = 1;
        for (int pile : piles) R = Math.max(R, pile);
        while (L + 1 < R) {
            int mid = (L + R) / 2;
            if (check(piles, H,  mid)) R = mid;
            else L = mid + 1;
        }
        //对剩下的2个进行选择
        return check(piles, H,  L) ? L : R;
    }

    private boolean check(int[] piles, int H, int K) {
        int spend = 0;
        for (int pile : piles) spend += (pile+K-1)/K; //向上取整的除法的特殊实现
        return spend <= H;
    }

    public static void main(String[] args) {
        int[] plies = {30, 11, 23, 4, 20};
        int H = 6;
        Q875_koko_eating_bananas s = new Q875_koko_eating_bananas();
        int i = s.minEatingSpeed(plies, H);
        System.out.println(i);
    }
}
