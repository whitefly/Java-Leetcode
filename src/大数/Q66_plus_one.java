package 大数;


import java.util.Arrays;

public class Q66_plus_one {
    public int[] plusOne(int[] digits) {
        /**
         * 思入: 大数加法,需要设置carry;
         */
        int carry = 0;
        int size = digits.length;
        digits[size - 1]++;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += carry;
            carry = digits[i] / 10;
            digits[i] %= 10;
        }
        //是否需要增加首位
        if (carry == 1) {
            int[] result = new int[size + 1];
            System.arraycopy(digits, 0, result, 1, size);
            result[0] = 1;
            return result;
        } else return digits;
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,1};
        Q66_plus_one s = new Q66_plus_one();
        int[] ints = s.plusOne(nums);
        System.out.println(Arrays.toString(ints));

    }
}
