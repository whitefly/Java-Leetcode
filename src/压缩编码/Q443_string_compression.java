package 压缩编码;

public class Q443_string_compression {
    public int compress(char[] chars) {
        char head = '\0';
        int count = 0;
        int store = 0;
        for (char c : chars) {
            if (c != head) {
                if (count != 0) {
                    String temp = count >= 2 ? head + "" + count + "" : head + "";
                    setStr(temp, chars, store);
                    store += temp.length();
                }
                head = c;
                count = 1;
            } else count++;
        }

        if (count != 0) {
            String temp = count >= 2 ? head + "" + count + "" : head + "";
            setStr(temp, chars, store);
            store += temp.length();
        }
        return store;
    }

    private void setStr(String content, char[] chars, int start) {
        for (int i = 0; i < content.length(); i++) {
            chars[start + i] = content.charAt(i);
        }
    }

    public static void main(String[] args) {
//        char[] chars = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
//        char[] chars = {'a'};
        char[] chars = {'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'};
        Q443_string_compression s = new Q443_string_compression();
        System.out.println(s.compress(chars));
    }
}
