package 双指针;


import java.util.*;

public class Q15_3sum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        //固定指针
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && nums[i - 1] == nums[i]) continue;
            int num1 = nums[i];
            int target = -num1;

            //双指针寻找余下2个数
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                while (j < k && j != i + 1 && nums[j - 1] == nums[j]) j++;  //只使用首次出现的数
                while (j < k && k != nums.length - 1 && nums[k] == nums[k + 1]) k--;

                if (j == k) break;

                int num2 = nums[j];
                int num3 = nums[k];
                if (num2 + num3 == target) {
                    result.add(Arrays.asList(num1, num2, num3));
                    j++;
                    k--;
                } else if (num2 + num3 < target) {
                    j++;
                } else {
                    k--;
                }
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int nums[] = {-2, 0, 0, 2, 2};
        Q15_3sum s = new Q15_3sum();
        List<List<Integer>> lists = s.threeSum(nums);
        System.out.println(lists);

    }
}
