package 哈希;

import java.util.ArrayList;

public class Q38_count_and_say {
    static ArrayList<String> buff = new ArrayList<>();

    static {
        buff.add("1");
    }

    public String countAndSay(int n) {
        /**
         * 思入: hash思想:  将数字进行分段.使用全局变量来加速
         */
        if (buff.size() - 1 >= n) return buff.get(n - 1);
        else {
            for (int i = buff.size(); i <= n; i++) {
                String last = buff.get(i - 1);
                int count = 1;
                char c = last.charAt(0);
                StringBuilder temp = new StringBuilder();
                for (int j = 1; j < last.length(); j++) {
                    if (last.charAt(j - 1) != last.charAt(j)) {
                        temp.append(count + "" + c);
                        c = last.charAt(j);
                        count = 1;
                    } else count++;
                }
                temp.append(count + "" + c);//最后一个
                buff.add(temp.toString());
            }
        }
        return buff.get(n - 1);
    }

    public static void main(String[] args) {
        Q38_count_and_say s = new Q38_count_and_say();
        System.out.println(s.countAndSay(5));
    }
}
