package 华为笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class HJ14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] all = new String[n];
        for (int i = 0; i < n; i++) {
            all[i] = scanner.nextLine();
        }
        Arrays.sort(all);
        Arrays.stream(all).forEach(System.out::println);
    }
}
