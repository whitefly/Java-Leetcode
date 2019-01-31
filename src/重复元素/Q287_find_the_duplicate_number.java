package 重复元素;

public class Q287_find_the_duplicate_number {


    public int findDuplicate(int[] nums) {
        /**
         * 思入: 数字都在[1,n]之间,说明数字的范围有限. 该题的一种主要思想就是想数字看做下标,然后遍历时,设置为负数.
         * 一旦碰到相同的下标,发现为负数,说明之间已经扫描过该索引. 之间返回该索引
         * 索引法缺点: 为了保存遍历状态,会修改原数组(不符合题意)
         */

        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int num = Math.abs(nums[i]);

            int temp = nums[num - 1];
            if (temp > 0) nums[num - 1] = -temp;
            else return num; //发现是负数,说明之前已经遍历过
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        /**
         * 思入: 快慢指针法. 看做是一个循环的链表
         */
        int fast = 0, slow = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) break;
        }
        int slow2 = 0;//从head点新开一个指针出发
        while (true) {
            slow = nums[slow];
            slow2 = nums[slow2];
            if (slow == slow2) break;
        }
        return slow2;
    }

}
