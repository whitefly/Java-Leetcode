package 概率;

import java.util.Arrays;

public class Q470_implement_rand10_using_rand7 {
    /*
    思入: 用2个随机数凑成二维概率分布.
     */
    public int rand10() {
        int a = rand7();  // 可以一般是oj自己给的rand7()函数
        int b = rand7();
        int temp = (a - 1) * 7 + b - 1;
        return temp < 40 ? temp % 10 + 1 : rand10();
    }

    private int rand7() {
        return (int) (Math.random() * 7) + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[11];
        int count = 100000;
        Q470_implement_rand10_using_rand7 solver = new Q470_implement_rand10_using_rand7();
        for (int i = 0; i < count; i++) {
            nums[solver.rand10()]++;
        }
        System.out.println(Arrays.toString(nums));

    }
}
