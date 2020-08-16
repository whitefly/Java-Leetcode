package 华为笔试题;

import java.util.Scanner;


public class HJ4 {
    static void solution(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i += 8) {
            int end = i + 8;
            if (end <= text.length()) {
                sb.append(text, i, end);
            } else {
                sb.append(text, i, text.length());
                int need = end - text.length(); //8   3  5
                for (int j = 0; j < need; j++) {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
        System.out.printf("%s", sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        solution(s1);
        solution(s2);
    }
}
