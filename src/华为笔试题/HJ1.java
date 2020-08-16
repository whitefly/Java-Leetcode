package 华为笔试题;

import java.util.Scanner;

public class HJ1 {
    static int solution(String s) {
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        System.out.println(solution(s));
    }
}
