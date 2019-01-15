package 字符串;

import java.math.BigInteger;

public class Q190_reverse_bits {
    /**
     * 思入: 暴力法,先转为 二进制字符串--->反转--->字符串转为整数--->输出
     * 问题: java是没有符号的. 一个n只能将其转为原码,
     */

    public int reverseBits(int n) {


        n = ((n & 0xFFFF0000) >> 16) | ((n & 0x0000FFFF) << 16);
        n = ((n & 0xFF00FF00) >> 8) | ((n & 0x00FF00FF) << 8);
        n = ((n & 0xF0F0F0F0) >> 4) | ((n & 0x0F0F0F0F) << 4);
        n = ((n & 0xcccccccc) >> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xaaaaaaaa) >> 1) | ((n & 0x55555555) << 1);
        return n;

    }

    public static void main(String[] args) {
        Q190_reverse_bits s = new Q190_reverse_bits();
        System.out.println(s.reverseBits(1));
    }
}
