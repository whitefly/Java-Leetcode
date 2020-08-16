package 华为笔试题;

import java.util.Scanner;

public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine().substring(2);
            System.out.println(Integer.parseInt(s, 16));
        }
    }
}
