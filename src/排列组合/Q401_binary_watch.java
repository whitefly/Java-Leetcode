package 排列组合;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Q401_binary_watch {
    private StringBuilder temp = new StringBuilder();
    private List<String> result = new ArrayList<>();
    private int count = 0;
    private int n;

    public List<String> readBinaryWatch(int num) {
        this.n = num;
        helper();
        return result;
    }


    private void helper() {
        if (temp.length() >= 10) {
            if (count == n) convertAndAdd(temp.toString());
            return;
        }
        temp.append('0');
        helper();
        temp.deleteCharAt(temp.length() - 1);

        if (count < n) {
            temp.append('1');
            count++;
            helper();
            count--;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    private void convertAndAdd(String n) {
        int hour = 0;
        for (int i = 0; i < 4; i++) hour += (n.charAt(i) - '0') * (1 << i);
        int minute = 0;
        for (int i = 4; i < 10; i++) minute += (n.charAt(i) - '0') * (1 << (i - 4));
        if (hour < 12 && minute < 60) result.add(String.format("%d:%02d", hour, minute));
    }

    public List<String> readBinaryWatch2(int num) {
        List<String> result = new ArrayList<>();
        int[] map = {0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 1, 2, 2, 3, 2, 3, 3, 4, 2, 3, 3, 4, 3, 4, 4, 5, 2, 3, 3, 4, 3, 4, 4, 5, 3, 4, 4, 5};
        for (int hour = 0; hour < 12; hour++) {
            if (map[hour] > num) continue;
            for (int minute = 0; minute < 60; minute++) {
                if ((map[hour] + map[minute]) == num) {
                    result.add(hour + ":" + ((minute <= 9) ? "0" + minute : minute));
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Q401_binary_watch s = new Q401_binary_watch();
        System.out.println(s.readBinaryWatch2(1));

    }


}
