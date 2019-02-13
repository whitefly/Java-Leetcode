package 栈;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class Q496_next_greater_element_i {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /**
         * 思入: 暴力搜索  在num2中找到对应的元素后,从该点开始,开始找右边第一个比它大的
         */
        int[] result = new int[nums1.length];
        HashMap<Integer, Integer> hash = new HashMap<>();
        int size1 = nums1.length, size2 = nums2.length;
        //记录
        for (int i = 0; i < size2; i++) hash.put(nums2[i], i);
        //遍历
        for (int i = 0; i < size1; i++) {
            int n1 = nums1[i], index = hash.get(n1) + 1;
            while (index < size2 && n1 > nums2[index]) index++;
            result[i] = (index == size2) ? -1 : nums2[index];
        }
        return result;
    }

    public int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        /**
         * 思入: 单调栈+hash的思想
         * 实现:先设置一个单调栈,依次找到 结果对应关系. 一旦找到答案,key-value中的key就可以从stack出来
         */
        int size1 = nums1.length;
        int[] result = new int[size1];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> hash = new HashMap<>();

        for (int n2 : nums2) {
            while (!stack.isEmpty() && stack.peek() < n2) hash.put(stack.pop(), n2);
            stack.push(n2);
        }
        //遍历num1;
        for (int i = 0; i < size1; i++) result[i] = hash.getOrDefault(nums1[i], -1);
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 4};
        int[] nums2 = {1, 2, 3, 4};
        Q496_next_greater_element_i s = new Q496_next_greater_element_i();
        int[] ints = s.nextGreaterElement2(nums1, nums2);
        System.out.println(Arrays.toString(ints));
    }
}
