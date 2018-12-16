package 双指针;

public class Q11_container_with_most_water {
    public int maxArea(int[] height) {
        /**
         * 思入: 长*高   由于双指针,长只会越来越短,最优解可能在 较高中产生
         */
        int l = 0, r = height.length - 1;
        int result = (r - l) * Math.min(height[l], height[r]);
        while (l < r) {
            if (height[l] <= height[r]) l++;
            else r--;
            result = Math.max((r - l) * Math.min(height[l], height[r]), result);
        }
        return result;
    }

    public static void main(String[] args) {
        Q11_container_with_most_water s = new Q11_container_with_most_water();
        int[] num = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};

        System.out.println(s.maxArea(num));

    }
}
