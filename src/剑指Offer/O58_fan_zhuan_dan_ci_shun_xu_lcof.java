package 剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class O58_fan_zhuan_dan_ci_shun_xu_lcof {
    public String reverseWords(String s) {
        String tag = " ";
        String[] split = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i =split.length - 1; i >=0; i--) {
            if (i != 0) sb.append(tag);
            sb.append(split[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String str = "   1    1   ";
        System.out.println(Arrays.toString(str.split("\\s+")));

    }
}
