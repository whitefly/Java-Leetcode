package 重复元素;

public class Q169_majority_element {
    public int majorityElement(int[] nums) {
        /**
         * 思入: 摩尔投票法.每次选2个不同的同归于尽.遍历后最后剩下的last,就是大于n/2的众数
         */
        int last = Integer.MIN_VALUE, count = 0;
        for (int num : nums) {
            if (count == 0) {
                last = num;
                count = 1;
            } else {
                if (last == num) count++;
                else count--;
            }
        }
        return last;

    }
}
