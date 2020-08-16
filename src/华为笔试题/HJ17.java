package 华为笔试题;

import java.util.Scanner;

public class HJ17 {

    static int[] check(String change) {
        if (change.length() > 3) return null;
        try {
            char direct = change.charAt(0);
            int num = Integer.parseInt(change.substring(1));
            switch (direct) {
                case 'A': {
                    return new int[]{-num, 0};
                }
                case 'S': {
                    return new int[]{0, -num};
                }
                case 'W': {
                    return new int[]{0, num};
                }
                case 'D': {
                    return new int[]{num, 0};
                }
                default:
                    return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String[] split = scanner.nextLine().split(";");
            int x = 0, y = 0;
            for (String change : split) {
                int[] move = check(change);
                if (move != null) {
                    x += move[0];
                    y += move[1];
                }
            }
            System.out.println(x + "," + y);
        }
    }
}
