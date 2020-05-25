package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class O46_ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof {
    Map<String, Integer> cache;

    public int translateNum(int num) {
        //动态规划
        if (num < 10) return 1;
        cache = new HashMap<>();
        return translateNum(String.valueOf(num));
    }

    int translateNum(String num) {
        if (num.length() <= 1) return 1;
        int one = translateNum(num.substring(1)), two = 0;
        int twoNum = Integer.parseInt(num.substring(0, 2));
        if (10 <= twoNum && twoNum <= 25) {
            two = translateNum(num.substring(2));
        }
        cache.put(num, one + two);
        return one + two;
    }


    public int translateNum2(int num) {
        //dp的方式, dp[i]表示以0~num[i]结尾的最大组合数
        //dp[i]= dp[i-1]+ dp[i-2] if [i-1,i]是数字
        if (num < 10) return 1;
        if (num < 26) return 2;
        String strNum = String.valueOf(num);
        int[] dp = new int[strNum.length()];
        dp[0] = 1;
        dp[1] = Integer.parseInt(strNum.substring(0, 2)) < 26 ? 2 : 1;
        for (int i = 2; i < strNum.length(); i++) {
            int substring = Integer.parseInt(strNum.substring(i - 1, i + 1));
            if (10 <= substring && substring <= 25) {
                dp[i] = dp[i - 2] + dp[i - 1];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[strNum.length() - 1];

    }

    public static void main(String[] args) {
        O46_ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof s = new O46_ba_shu_zi_fan_yi_cheng_zi_fu_chuan_lcof();
        System.out.println(s.translateNum2(25));
    }
}
