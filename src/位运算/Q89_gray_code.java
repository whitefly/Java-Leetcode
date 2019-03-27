package 位运算;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q89_gray_code {
    public List<Integer> grayCode(int n) {
        /**
         * 思入:  将nums分为2个类,第1类的转换为找到最右边的第一个,然后进行转换.
         * 第2类的转换是找到最右边第1个1,然后转变其左边位
         */
        // 二进制码转为格雷码的公式  i ^ (i >> 1)
        int size = 1 << n;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < size; i++) result.add(i ^ (i >> 1));
        return result;
    }

    public static void main(String[] args) {
        Q89_gray_code s = new Q89_gray_code();
        List<Integer> integers = s.grayCode(0);
        System.out.println(integers);
    }
}
