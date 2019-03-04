package 动态规划;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q119_pascals_triangle_ii {
    public List<Integer> getRow(int rowIndex) {
        /**
         * 思入: 直接申请k大小的数组.然后原地进行累计和覆盖.
         */
        rowIndex++;
        Integer[] result = new Integer[rowIndex];
        Arrays.fill(result, 0);
        result[0] = 1;
        int last = 0;
        for (int size = 1; size < rowIndex; size++) {
            for (int j = 0; j < size + 1; j++) {
                int temp = result[j];
                result[j] = last + result[j];
                last = temp;
            }
        }
        return Arrays.asList(result);
    }

    public static void main(String[] args) {
        Q119_pascals_triangle_ii s = new Q119_pascals_triangle_ii();
        List<Integer> row = s.getRow(2);
        System.out.println(row);
    }
}
