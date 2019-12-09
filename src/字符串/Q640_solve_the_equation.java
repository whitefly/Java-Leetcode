package 字符串;

import com.sun.tools.javac.util.Assert;

public class Q640_solve_the_equation {
    public String solveEquation(String equation) {
        /*
       思入: 将字符串根据根号来划分
         */

        int factor = 0, num = 0;
        String replace = equation.replace("+", "_+").replace("-", "_-");
        String[] split = replace.split("=");
        String left = split[0], right = split[1];


        for (String item : left.split("_")) {
            if (item.equals("")) continue;
            if (item.contains("x")) {
                factor += getFactor(item);
            } else {
                num -= Integer.parseInt(item);
            }
        }

        for (String item : right.split("_")) {
            if (item.equals("")) continue;
            if (item.contains("x")) {
                factor -= getFactor(item);
            } else {
                num += Integer.parseInt(item);
            }
        }

        if (factor == 0) {
            if (num == 0) return "Infinite solutions";
            else return "No solution";
        } else {
            return "x=" + (num / factor);
        }
    }

    private int getFactor(String item) {
        if ("x".equals(item) || "+x".equals(item)) {
            return 1;
        } else if ("-x".equals(item)) {
            return -1;
        }
        return Integer.parseInt(item.substring(0, item.length() - 1));
    }

    public static void main(String[] args) {
        Q640_solve_the_equation solver = new Q640_solve_the_equation();
//        String target = "x+5-3+x=6+x-2";
//        String target = "x=x";
//        String target = "2x=x";
//        String target = "2x+3x-6x=x+2";
        String target = "x=x+2";
        System.out.println(solver.solveEquation(target));

    }
}
