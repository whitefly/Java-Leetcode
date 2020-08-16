package 华为笔试题;


import java.util.Scanner;

public class HJ10 {
    public static void main(String[] args) {
        boolean[] map = new boolean[128];
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int count = 0;
        for (char c : chars) {
            if (!map[c]) {
                count++;
                map[c] = true;
            }
        }
        System.out.println(count);
    }
}
