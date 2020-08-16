package 华为笔试题;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HJ6 {
    static void solution(int num) {
        if (num == 1) {
            System.out.println(num);
            return;
        }
        StringBuilder sb = new StringBuilder();
        int rest = num;
        for (int divide = 2; rest != 1 && divide <= num; divide++) {
            while (rest != 1 && rest % divide == 0) {
                rest /= divide;
                sb.append(divide).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        solution(i);
    }
}
