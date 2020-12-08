package 回溯剪枝;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q842_split_array_into_fibonacci_sequence {
    List<Integer> rnt;
    List<Integer> temp = new ArrayList<>();

    public List<Integer> splitIntoFibonacci(String S) {
        //只确定前2个数,后面的数列就固定了
        helper(S, 0, 0, 0);
        return rnt == null ? Collections.emptyList() : rnt;
    }

    private void helper(String rest, int pre1, int pre2, int deep) {
        //deep表示temp已经含有的数
        if (rnt != null) return;
        if (rest.isEmpty() && deep >= 3) {
            rnt = new ArrayList<>(temp);
            return;
        }
        for (int i = 1; i <= 12 && i <= rest.length(); i++) {
            if (rest.charAt(0) == '0' && i != 1) break; //开头为0时,只取一次(这么写为了将开头为0的情况和for循环合并到一起)
            long l = Long.parseLong(rest.substring(0, i));
            if (deep >= 2 && (l != (pre1 + pre2))) continue;
            temp.add((int) l);
            helper(rest.substring(i), pre2, (int) l, deep + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Q842_split_array_into_fibonacci_sequence solution = new Q842_split_array_into_fibonacci_sequence();
        String content = "1101111";
        System.out.println(solution.splitIntoFibonacci(content));
    }
}
