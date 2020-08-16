package 华为笔试题;

import java.util.*;

public class HJ8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            int index = Integer.parseInt(s[0]);
            int num = Integer.parseInt(s[1]);
            map.merge(index, num, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> item : map.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}
