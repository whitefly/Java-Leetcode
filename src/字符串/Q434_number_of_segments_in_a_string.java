package 字符串;

public class Q434_number_of_segments_in_a_string {
    public int countSegments(String s) {
        /*
        思入: 字符串分割,','也算字符
         */
        String trim = s.trim();
        if (trim.length() == 0) return 0;
        int index = -1, count = 0;
        do {
            index = trim.indexOf(' ', index);
            if (index == -1) break;
            if (trim.charAt(index - 1) != ' ') count++;
            index++;
        } while (true);
        return count + 1;
    }

    public static void main(String[] args) {
        String word = "Hello, my name is John";
        Q434_number_of_segments_in_a_string s = new Q434_number_of_segments_in_a_string();
        System.out.println(s.countSegments(word));
    }
}
