package 字符串;

public class Q58_length_of_last_word {
    public int lengthOfLastWord(String s) {
        /**
         * 思入: 直接调用字符串分解api,找最后一个非''的字符串
         */
        String[] nums = s.split(" ");
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i].length() != 0) return nums[i].length();
        }
        return 0;
    }

    public int lengthOfLastWord2(String s) {
        /**
         * 思入: 从后向前遍历,使用有限状态机的思想
         */
        boolean begin = false;
        int size = 0;
        char[] chars = s.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                if (!begin) begin = true;
                size++;
            } else if (begin) return size;
        }
        return size;
    }

    public static void main(String[] args) {

        String a = "b   a    ";
        Q58_length_of_last_word s = new Q58_length_of_last_word();
        int i = s.lengthOfLastWord2(a);
        System.out.println(i);
    }
}
