package 华为笔试题;


import java.util.Scanner;

public class HJ13 {


    static private void helper(Object[] array) {
        int L = 0, R = array.length - 1;
        while (L < R) {
            Object o = array[L];
            array[L] = array[R];
            array[R] = o;
            L++;
            R--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        helper(s);
        System.out.println(String.join(" ", s));
    }
}
