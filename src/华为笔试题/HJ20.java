package 华为笔试题;

import java.util.Scanner;

public class HJ20 {
    static boolean checkLength(String pw) {
        return pw.length() > 8;
    }

    static boolean checkVariety(String pw) {
        byte little = 0, big = 0, hasNum = 0, other = 0;
        for (char c : pw.toCharArray()) {
            if (c == ' ') continue;
            if ('a' <= c && c <= 'z') little = 1;
            else if ('A' <= c && c <= 'Z') big = 1;
            else if ('0' <= c && c <= '9') hasNum = 1;
            else other = 1;
            if ((little + big + hasNum + other) >= 3) return true;
        }
        return false;
    }

    static boolean checkRepeat(String pw) {
        for (int i = 0; i < pw.length(); i++) {
            for (int j = i + 2; j < pw.length(); j++) {
                String substring = pw.substring(i, j + 1);
                int i1 = pw.indexOf(substring, j + 1);
                if (i1 != -1) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            boolean ok = checkLength(s) && checkVariety(s) && checkRepeat(s);
            System.out.println(ok ? "OK" : "NG");
        }
    }
}
