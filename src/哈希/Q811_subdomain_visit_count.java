package 哈希;

import java.util.*;

public class Q811_subdomain_visit_count {
    public List<String> subdomainVisits(String[] cpdomains) {
        /**
         * 思想:  字符串拆分,然后作为key统计总和
         */
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : cpdomains) {
            int position = s.indexOf(" ");
            int count = Integer.valueOf(s.substring(0, position));
            s = "." + s.substring(position + 1);
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '.') {
                    String key = s.substring(i + 1);
                    map.put(key, map.containsKey(key) ? map.get(key) + count : count);
                }
            }
        }
        //返回结果
        ArrayList<String> r = new ArrayList();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            r.add(entry.getValue() + " " + entry.getKey());
        }
        return r;
    }

    public static void main(String[] args) {
        Q811_subdomain_visit_count s = new Q811_subdomain_visit_count();
        String[] hehe = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> strings = s.subdomainVisits(hehe);
        System.out.println(strings);
        //[951 com, 900 google.mail.com, 1 intel.mail.com, 5 org, 5 wiki.org, 901 mail.com, 50 yahoo.com]
        //["901 mail.com","50 yahoo.com","900 google.mail.com","5 wiki.org","5 org","1 intel.mail.com","951 com"]
    }
}
