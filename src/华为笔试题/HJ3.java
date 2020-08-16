package 华为笔试题;

import java.util.Arrays;
import java.util.Scanner;

public class HJ3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean[] map = new boolean[1000];
        while (scanner.hasNextLine()) {
            Arrays.fill(map, false);
            int n = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < n; i++) {
                int temp = Integer.parseInt(scanner.nextLine());
                map[temp] = true;
            }
            for (int i = 0; i < map.length; i++) {
                if (map[i]) {
                    System.out.println(i);
                }
            }
        }
    }
}
