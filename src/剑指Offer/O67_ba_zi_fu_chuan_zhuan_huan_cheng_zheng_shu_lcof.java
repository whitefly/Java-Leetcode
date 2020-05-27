package 剑指Offer;

public class O67_ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu_lcof {
    public int strToInt(String str) {
        boolean flag = false; //处于数字字符中
        boolean neg = false;
        long result = 0;  //总是为正
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (flag) {
                if (isNum(c)) {
                    result = result * 10 + c - '0';
                    if (isOverflow(result, neg)) return neg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else break;
            } else {
                if (isNum(c)) {
                    result = result * 10 + c - '0';
                    flag = true;
                } else if (c == '+' || c == '-') {
                    flag = true;
                    if (c == '-') neg = true;
                } else if (c == ' ') {
                } else {
                    break;
                }
            }
        }
        return neg ? (int) -result : (int) result;
    }


    boolean isNum(char c) {
        int n = c - '0';
        return 0 <= n && n <= 9;
    }

    boolean isOverflow(long num, boolean neg) {
        if (neg) {
            return -num < Integer.MIN_VALUE;
        } else return num > Integer.MAX_VALUE;
    }


    public static void main(String[] args) {
        String num = " -1";
        O67_ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu_lcof s = new O67_ba_zi_fu_chuan_zhuan_huan_cheng_zheng_shu_lcof();
        int i = s.strToInt(num);
        System.out.println(i);
    }
}
