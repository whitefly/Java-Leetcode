package 华为笔试题;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HJ21 {
    static Map<Character, Character> map = new HashMap<>(32);

    static {
        map.put('a', '2');
        map.put('b', '2');
        map.put('c', '2');

        map.put('d', '3');
        map.put('e', '3');
        map.put('f', '3');

        map.put('g', '4');
        map.put('h', '4');
        map.put('i', '4');

        map.put('j', '5');
        map.put('k', '5');
        map.put('l', '5');

        map.put('m', '6');
        map.put('n', '6');
        map.put('o', '6');

        map.put('p', '7');
        map.put('q', '7');
        map.put('r', '7');
        map.put('s', '7');

        map.put('t', '8');
        map.put('u', '8');
        map.put('v', '8');

        map.put('w', '9');
        map.put('x', '9');
        map.put('y', '9');
        map.put('z', '9');


    }

    static char mapChar(char c) {
        if (Character.isDigit(c)) return c;
        if (Character.isUpperCase(c)) {
            char c1 = Character.toLowerCase(c);
            if (c1 == 'z') return 'a';
            return (char) (c1 + 1);
        } else {
            return map.get(c);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            String s = scanner.nextLine();
            StringBuilder sb = new StringBuilder();
            for (char c : s.toCharArray()) {
                sb.append(mapChar(c));
            }
            System.out.println(sb.toString());
        }
    }
}
