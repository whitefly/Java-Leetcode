package 排版题;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q118_pascals_triangle {
    public List<List<Integer>> generate(int numRows) {
        /**
         * 思入: 每行比上行增加1个, 推出2个父亲下标即可
         */

        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;

        for (int i = 0; i < numRows; i++) {
            List<Integer> temp = new ArrayList();
            if (i == 0) {
                temp.add(1);  //第一行
            } else {
                int size = i + 1;  //剩下的行
                List<Integer> last = result.get(i - 1);
                for (int j = 0; j < size; j++) {
                    int num1 = (j - 1 < 0) ? 0 : last.get(j - 1);
                    int num2 = (j >= i) ? 0 : last.get(j);
                    temp.add(num1 + num2);
                }
            }
            result.add(temp);

        }
        return result;
    }

    public static void main(String[] args) {
        Q118_pascals_triangle s = new Q118_pascals_triangle();
        List<List<Integer>> generate = s.generate(5);
        System.out.println(generate);
    }
}
