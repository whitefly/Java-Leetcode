package 华为笔试题;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class HJ9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();

        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (!set.contains(chars[i])) {
                sb.append(chars[i]);
                set.add(chars[i]);
            }
        }
        System.out.println(sb.toString());
    }
}
