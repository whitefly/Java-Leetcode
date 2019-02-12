package 排列组合;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q60_permutation_sequence {
    StringBuilder temp = new StringBuilder();
    boolean gone[];
    boolean end = false;
    int my_k;
    String r;


    public String getPermutation(int n, int k) {
        /**
         * 思入1: 深度搜索找到所有路径(回溯剪枝). 分支是还没有使用的数字(所以设置一个gone变量). 由于是第k个,需要记个数,达到k时才加入结果集
         * 时间: ,但是由于找到后直接剪枝后面的,所以没超时.但是耗时还是比较慢
         */
        my_k = k;
        gone = new boolean[n + 1];
        hepler(n);
        return r;

    }

    private void hepler(int n) {
        if (end) return;
        if (temp.length() == n) {
            my_k--;
            if (my_k == 0) {
                r = temp.toString();
                end = true;
            }
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (gone[i]) continue;
            gone[i] = true;
            temp.append(i);
            hepler(n);
            gone[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public String getPermutation2(int n, int k) {
        /**
         * 思入: 通过k,来直接确定每次的数字,然后计算新k
         */
        LinkedList<Integer> nums = new LinkedList<>();
        for (int i = 1; i <= n; i++) nums.add(i);
        StringBuilder result = new StringBuilder();

        k--;
        int group_size = 1;  //group_size为每次的阶乘,分别为(n-1)!,(n-2)!...直到为1
        for (int i = 1; i < n; i++) group_size *= i;

        while (nums.size() > 1) {
            //添加数字
            int group_id = k / group_size;
            result.append(nums.get(group_id));
            //减去nums中的数字,并计算新下标
            k %= group_size;
            nums.remove(group_id);
            group_size /= nums.size();
        }
        result.append(nums.get(0));
        return result.toString();
    }

    public static void main(String[] args) {
        Q60_permutation_sequence s = new Q60_permutation_sequence();
        String permutation = s.getPermutation2(4, 9);
        System.out.println(permutation);
    }
}
