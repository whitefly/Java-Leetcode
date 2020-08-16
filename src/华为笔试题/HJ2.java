package 华为笔试题;

import java.util.Scanner;

public class HJ2 {
    static int solution(String s, String c) {
        int count = 0, index = -1;
        do {
            index = s.indexOf(c, index + 1);
            if (index != -1) count++;
        } while (index != -1);
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String all = scanner.nextLine();
        String target = scanner.nextLine();
        System.out.println(solution(all.toLowerCase(), target.toLowerCase()));
    }
}
