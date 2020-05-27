package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O57_he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof {
    public int[][] findContinuousSequence(int target) {
        //连续的,滑动窗口
        List<int[]> container = new ArrayList<>();
        int sum = 0, L, R, limit = (target + 1) / 2;
        for (L = 1, R = 1; R <= limit; R++) {
            sum += R;
            while (target <= sum) {
                if (sum == target) container.add(range(L, R));
                sum -= L;
                L++;
            }
        }
        return container.toArray(new int[0][]);  //换成数组形式
    }

    int[] range(int i, int j) {
        int[] rnt = new int[j - i + 1];
        for (int k = 0, v = i; v <= j; v++, k++) rnt[k] = v;
        return rnt;
    }

    public static void main(String[] args) {
        O57_he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof s = new O57_he_wei_sde_lian_xu_zheng_shu_xu_lie_lcof();
        int[][] continuousSequence = s.findContinuousSequence(15);
        for (int[] item : continuousSequence) {
            System.out.println(Arrays.toString(item));
        }
    }

}
