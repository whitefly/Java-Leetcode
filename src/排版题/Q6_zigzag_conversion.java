package 排版题;

import java.util.ArrayList;

public class Q6_zigzag_conversion {
    public String convert(String s, int numRows) {
        /**
         * 遍历每一行,然后生成该行的字符下标
         */
        //加速
        if (numRows == 1) return s;
        //遍历下标
        StringBuilder r = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            ArrayList<Integer> index_list = get_index(i, numRows, s.length() - 1);
            for (int index : index_list) r.append(s.charAt(index));
        }
        return r.toString();

    }

    private ArrayList<Integer> get_index(int init_index, int numRows, int limit) {
        ArrayList<Integer> r = new ArrayList<>();
        int size = limit / numRows;
        int next = (numRows - 1) * 2;
        int extra = (numRows - init_index) * 2 - 2;
        boolean is_bargin = (extra == 0 || extra == next);
        for (int i = 0; i <= size; i++) {
            int index1 = init_index + next * i;  //第一个数
            int index2 = index1 + extra;        //第二个数

            if (index1 <= limit) r.add(index1);
            if (index2 <= limit && !is_bargin) r.add(index2);
        }
        return r;
    }

    public static void main(String[] args) {
        Q6_zigzag_conversion s = new Q6_zigzag_conversion();
        String s1 = "LEETCODEISHIRING";
        int numRows = 3;

        System.out.println(s.convert(s1, numRows));

    }

}
