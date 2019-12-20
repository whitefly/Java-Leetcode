package 贪心;

import java.util.Arrays;
import java.util.Comparator;

public class Q646_maximum_length_of_pair_chain {
    public int findLongestChain(int[][] pairs) {
    /*
    思入: 考研机试中的贪心题目.找出某个时段后,结束时间最短的一个.
     */
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));

        int count = 0;
        int last = Integer.MIN_VALUE;
        int index = 0;
        while (true) {
            int temp = Integer.MAX_VALUE;
            int tempIndex = -1;
            for (int i = index; i < pairs.length; i++) {
                if (last >= pairs[i][0]) continue;
                if (pairs[i][1] < temp) {
                    tempIndex = i;
                    temp = pairs[i][1];
                }
            }
            if (tempIndex == -1) return count;
            count++;
            last = temp;
            index = tempIndex + 1;
        }
    }

    public int findLongestChain2(int[][] pairs) {
        /*
        思入: 贪心策略和他们差不多,可以减少复杂度
         */
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int count = 0, temp = Integer.MIN_VALUE;
        for (int i = 0; i < pairs.length; i++) {
            if (temp < pairs[i][0]) {
                count++;
                temp = pairs[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[][] nums = {{1, 2}, {2, 3}, {3, 4}};
        int[][] nums = {{-10, -8}, {8, 9}, {-5, 0}, {6, 10}, {-6, -4}, {1, 7}, {9, 10}, {-4, 7}};
        Q646_maximum_length_of_pair_chain solver = new Q646_maximum_length_of_pair_chain();
        System.out.println(solver.findLongestChain2(nums));
    }
}
