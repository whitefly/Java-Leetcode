package 贪心;

public class Q134_gas_station {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        /**
         * 思入: 贪心思想:  设置一个还需要的累积油量,
         *  启发1: 初始油量0,可以回环,那么初始油量有正,更可以回环.(所以初始点一定在前面)
         *  启发2: 若累积需要油量在末尾为负数,则一定无法回环
         *  启发3: 若 本站新加的 ＜ 本段所需要的,不一定需要变化begin. 将从begin累加的剩余量 与之比较, 若不够,才需要变化begin
         */
        int need_sum = 0, size = gas.length, rest = 0;
        int begin = 0;
        for (int i = 0; i < size; i++) {
            need_sum += cost[i] - gas[i];
            rest -= cost[i] - gas[i];
            if (rest < 0) {
                begin = (i + 1) % size;
                rest = 0;
            }
        }
        if (need_sum > 0) return -1;
        return begin;
    }

    public static void main(String[] args) {
        int[] gas = {7, 1, 0, 11, 4};

        int[] cost = {5, 9, 1, 2, 5};

        Q134_gas_station s = new Q134_gas_station();
        int i = s.canCompleteCircuit(gas, cost);
        System.out.println(i);
    }
}
