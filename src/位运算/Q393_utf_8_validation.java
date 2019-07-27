package 位运算;

import java.util.Arrays;

public class Q393_utf_8_validation {
    private static final int REST = 0b10 << 6;
    private static final int[] SIZE_MASK = {0, 0b1 << 7, 0b11 << 6, 0b111 << 5, 0b1111 << 4};
    private static final int[] SIZE_PREFIX = {0, 0, 0b110 << 5, 0b1110 << 4, 0b11110 << 3};


    public boolean validUtf8(int[] data) {
        int scan = 0;
        while (scan < data.length) {
            int size = getSize(data[scan]);
            if (!validOne(data, scan, scan + size - 1)) return false;
            scan += size;
        }
        return true;
    }

    private boolean validOne(int[] data, int start, int end) {
        int size = end - start + 1;
        if (start >= data.length || end >= data.length) return false;
        if (size < 1 || size > 4) return false;
        if ((data[start] & SIZE_MASK[size]) != SIZE_PREFIX[size]) return false;
        for (int i = start + 1; i <= end; i++) {
            if ((data[i] & SIZE_MASK[2]) != REST) return false;
        }
        return true;
    }

    private int getSize(int head) {
        int count = 0;
        int mark = 0b10000000;
        while ((head & mark) != 0) {
            count++;
            head <<= 1;
        }
        return count == 0 ? 1 : count;
    }

    private void show(int[] nums) {
        for (int num : nums) {
            System.out.println(Integer.toBinaryString(num));
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        int[] nums = {235, 140, 4};
        int[] nums = {240, 162, 138, 147};
        Q393_utf_8_validation s = new Q393_utf_8_validation();
        System.out.println(s.validUtf8(nums));

    }
}
