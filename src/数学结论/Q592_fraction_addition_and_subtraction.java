package 数学结论;

import java.util.Arrays;

public class Q592_fraction_addition_and_subtraction {
    public String fractionAddition(String expression) {
        /*
        思入: 用+或者-来分离,获取分母的最小公倍数,计算出最后结果后,用分子和分母的最大公约数来进行约分
         */
        String target = expression.replace("+", "_+").replace("-", "_-");
        String[] split = target.split("_");
        long[] ups = new long[split.length];
        long[] downs = new long[split.length];

        long LCM = 1;
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) continue;

            String[] one = split[i].split("/");
            ups[i] = Long.parseLong(one[0]);
            downs[i] = Long.parseLong(one[1]);
            LCM = getLCM(LCM, downs[i]);
        }

        //计算整体
        long finalUp = 0;
        for (int i = 0; i < split.length; i++) {
            if ("".equals(split[i])) continue;
            finalUp += ups[i] * LCM / downs[i];
        }
        //返回结果
        long divide = getGCD(Math.abs(finalUp), LCM);
        return String.format("%d/%d", finalUp / divide, LCM / divide);
    }


    private long getGCD(long a, long b) {
        long temp = a % b;
        if (temp == 0) {
            return b;
        } else {
            return getGCD(b, temp);
        }
    }

    private long getLCM(long a, long b) {
        return a * b / getGCD(a, b);
    }

    public static void main(String[] args) {
//        String express = "-1/2+1/2";
//        String express = "-1/2+1/2+1/3";
//        String express = "1/3-1/2";
        String express = "-1/2+1/3";

        Q592_fraction_addition_and_subtraction solver = new Q592_fraction_addition_and_subtraction();
        System.out.println(solver.fractionAddition(express));
        System.out.println(solver.getLCM(2, 3));
    }


}
