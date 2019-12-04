package 背包问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q638_shopping_offers {
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        /*
        思入: 多重背包问题. 从满足总重量,到满足各个特定的重量[j][w]  -> [j][a][b][c][d][]
        k最多被6次,最小花费
        内循环的目录是遍历每一种状态. 将多维数组转为单位数组
         */

        int count = price.size() + special.size();

        int[][] dp = new int[needs.get(0) + 1][needs.get(1) + 1];

        for (int i = 0; i < price.size(); i++) {
            //构造单个组
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j <= price.size(); j++) {
                temp.add(0);
            }
            temp.set(i, 1);
            temp.set(price.size(), price.get(price.get(i)));
            special.add(temp);
        }
        //多重背包
        for (int i = 0; i < special.size(); i++) {
            for (int k = 0; k < 6; k++) {

            }

        }
        return 0;
    }

    public int shoppingOffers2(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int[] Decinal = {1, 7, 49, 343, 2401, 16807, 117649}; // 7的一次方，7的二次方....用于算7进制数转10进制数。
        int goods = price.size(); // 物品的总数量。
        for (int i = 0; i < goods; i++) { // 把每一个物品各买一个的情况放入大礼包中，因为大礼包不可能正好等于needs，还要添加单个买的数量。
            List<Integer> tmp = new ArrayList();
            for (int j = 0; j < goods; j++) tmp.add(0);
            tmp.set(i, 1);
            tmp.add(price.get(i));
            special.add(tmp);
        }
        int box = special.size(); // 大礼包的数量。
        int tol = change(needs, goods, Decinal); // 算出总量,比如needs是[1,2,1],那么就会算出64，也就是说有0-64个情况。[0,0,0]-[1,2,1](7进制)
        long[] dp = new long[tol + 1]; // 每一种情况放在数组的相应位置。注意这里类型必须是long或以上，否则等会比大小的时候会因为过大而溢出。
        Arrays.fill(dp, Integer.MAX_VALUE); // 初始化为最大值。
        dp[0] = 0; // base case 0。
        for (int i = 0; i < box; i++) {
            for (int j = 0; j <= tol; j++) {
                if (!check(special.get(i), needs, j)) continue; // 检查加上这个大礼包后是不是多出去了。
                int state = change(special.get(i), goods, Decinal) + j; // 算出加上大礼包后在dp中对应的位置。

                dp[state] = Math.min(dp[state], dp[j] + special.get(i).get(goods)); // 更新dp，取最小的情况。
            }
        }
        return (int) dp[tol]; // 返回，注意强转回int类型。
    }

    public int change(List<Integer> sp, int n, int[] Deci) { // 把7进制数变为10进制数。
        int res = 0;
        for (int i = 0; i < n; i++) res += sp.get(i) * Deci[i]; // 7变10公式,sp[i] * 7 ** i,i从0开始。
        return res;
    }

    public boolean check(List<Integer> sp, List<Integer> needs, int cur) { // 检查数量是否小于needs。
        for (int i = 0; i < sp.size() - 1; i++) {
            if (cur % 7 + sp.get(i) > needs.get(i)) return false;//7进制最左边一位就是a物品的数量，加上当前大礼包后和needs的a物品数量进行比较
            cur /= 7; // 相当于向右移一位，那么a物品就没了，最左边的变成了b物品。
        }
        return true;
    }


}
