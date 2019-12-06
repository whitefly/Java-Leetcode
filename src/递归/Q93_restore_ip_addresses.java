package 递归;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q93_restore_ip_addresses {
    private static int len = 4;

    public List<String> restoreIpAddresses(String s) {
        List<List<String>> result = helper(s, 0, len);
        List<String> rnt = new ArrayList<>();
        for (List<String> item : result) {
            rnt.add(String.join(".", item));
        }
        return rnt;
    }

    private List<List<String>> helper(String s, int index, int n) {
        if (s.length() <= index || n * 3 < (s.length() - index)) {
            return new LinkedList<>();
        }
        if (n == 1) {
            List<List<String>> objects = new LinkedList<>();
            if (checkIp(s.substring(index))) {
                List<String> temp = new LinkedList<>();
                temp.add(s.substring(index));
                objects.add(temp);
            }
            return objects;
        }

        List<List<String>> result = new LinkedList<>();
        for (int i = 1; i <= 3; i++) {
            if (((index + i) > s.length())) continue;
            String strNum = s.substring(index, index + i);
            if (checkIp(strNum)) {
                List<List<String>> subResult = helper(s, index + i, n - 1);
                if (subResult.size() != 0) {
                    for (List<String> item : subResult) item.add(0, strNum);
                }
                result.addAll(subResult);
            }
        }
        return result;
    }


    private boolean checkIp(String num) {
        int result = Integer.parseInt(num);
        if (num.length() == 1) return true;
        else if (num.length() == 2) return 10 <= result && result <= 99;
        else return 100 <= result && result <= 255;
    }

    public static void main(String[] args) {
        String target = "25525511135";
        Q93_restore_ip_addresses solver = new Q93_restore_ip_addresses();
//        solver.helper("255255", 0, 2);
        List<String> strings = solver.restoreIpAddresses(target);
        System.out.println(strings);
    }
}
