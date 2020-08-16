package 华为笔试题;

import java.util.Scanner;

public class HJ15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine()), count = 0;
        while (n != 0) {
            n &= n - 1;
            count++;
        }
        System.out.println(count);
    }
}
