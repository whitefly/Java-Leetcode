package 双指针;

public class Q345_reverse_vowels_of_a_string {
    /*
    思入: 反向双指针,知道相遇. 有点类似快排的思想
     */

    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        int L = 0, R = s.length() - 1;
        while (L < R) {
            while (L < R && !isVowel(chars[L])) L++;
            while (L < R && !isVowel(chars[R])) R--;
            swap(chars, L++, R--);
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }

    private void swap(char[] chars, int a, int b) {
        char temp = chars[a];
        chars[a] = chars[b];
        chars[b] = temp;
    }

    public static void main(String[] args) {
        Q345_reverse_vowels_of_a_string s = new Q345_reverse_vowels_of_a_string();
        System.out.println(s.reverseVowels("leetcode"));
    }
}
