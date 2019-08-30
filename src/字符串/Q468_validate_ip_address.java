package 字符串;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Q468_validate_ip_address {
    public String validIPAddress(String IP) {
        /*
        思入: 字符串分割,判断是否:或者., 则使用:来分割,然后判断单个数字是否合法
         */

        if (IP.contains(".")) {
            if (IP.charAt(IP.length() - 1) == '.') return "Neither";
            return checkIp4(IP.toLowerCase().split("\\.")) ? "IPv4" : "Neither";
        } else if (IP.contains(":")) {
            if (IP.charAt(IP.length() - 1) == ':') return "Neither";
            return checkIp6(IP.toLowerCase().split(":")) ? "IPv6" : "Neither";
        } else return "Neither";
    }

    private boolean checkIp4(String[] nums) {
        if (nums.length != 4) return false;
        for (String num : nums) {
            if (!checkNumOfIp4(num)) return false;
        }
        return true;
    }

    private boolean checkNumOfIp4(String num) {
        try {
            if (num.length() == 0 || num.length() > 3) return false;
            int temp = num.charAt(0) - '0';
            if (!(0 <= temp && temp <= 9)) return false;
            int i = Integer.parseInt(num);
            if (i >= 1 && i <= 255 && num.indexOf('0') != 0) return true;
            return i == 0 && num.length() == 1;
        } catch (Exception e) {
            return false;
        }
    }


    private boolean checkIp6(String[] nums) {
        if (nums.length != 8) return false;
        for (String num : nums) {
            if (!checkNumOfIp6(num)) return false;
        }
        return true;
    }

    private boolean checkNumOfIp6(String num) {
        try {
            if (num.length() == 0 || num.length() > 4) return false;
            int temp = num.charAt(0) - '0';
            if (!((0 <= temp && temp <= 9) || (49 <= temp && temp <= 54))) return false;
            Integer.parseInt(num, 16);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static void main(String[] args) {
//        String demo = "172.16.254.1";
//        String demo = "2001:0db8:85a3:0:0:8A2E:0370:7334";
//        String demo = "256.256.256.256";
        String demo = "2001:0db8:85a3:0:0:8A2E:0370:7334:";
        String demo1 = ":2001:0db8:85a3:0:0:8A2E:0370:7334:";

        System.out.println(Arrays.toString(demo1.split(":")));
        System.out.println('f' - '0'); //49 54
        Q468_validate_ip_address s = new Q468_validate_ip_address();
        System.out.println(s.validIPAddress(demo));
    }


}
