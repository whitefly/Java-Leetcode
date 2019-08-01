package 二分;

public class Q4_median_of_two_sorted_arrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        /**
         * 首先定义这里的中位数下标为左中位数. 即 总数为5,则为第3个数(从1开始), 若总是为6,第3个数(从1开始)
         *思入: 2刀的位置,左边同属于,右边同属于大.
         *
         * 核心1: 什么时候该左移,什么时候该右移? (左边候选数>右边候选数时,就需要移动. 分2种情况,L1>R2 或者 L2>R1,2中情况移动方向不一样)
         * 核心2: 奇数该怎么处理,为什么会导致cut2越界? cut1+cut2=左中位个数 由于cut1初始化时可能为0,导致cut2=左中位个数,但是第二个数组的容量可能只有1个,所以直接越界了.所以为了避免这种情况,第二个数组的长度至少要达到一半(即替换为较长的那个)
         * 核心3: 在为奇数时,必须求右边的部分是不好解释的?  统一取左中位数
         * 总结:这个解法对count为偶数时,好理解;但是count为奇数时,无法解释. 放弃这个解法
         */

        int size1 = nums1.length, size2 = nums2.length;
        if (size1 > size2) return findMedianSortedArrays(nums2, nums1);
        int count = size1 + size2;
        int l = 0, r = nums1.length;
        int k = (count + 1) / 2;  //此时mid-1表示左中位点,比如总数有4个,则mid=2(左中位下标为1),若总是有5个,则表示3(左中位下标为2)
        while (l <= r) {
            int cut1 = (l + r) / 2;
            int cut2 = k - cut1;    //偶数没问题,但奇数且 len1>len2时,求出来的cut2又是会超过len2.导致num2[cut2]越界
            //是否满足条件左边最大<=右边最小
            int L1 = (cut1 == 0) ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int L2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int R1 = (cut1 == size1) ? Integer.MAX_VALUE : nums1[cut1];
            int R2 = (cut2 == size2) ? Integer.MAX_VALUE : nums2[cut2];

            if (L1 > R2) r = cut1 - 1;
            else if (L2 > R1) l = cut1 + 1;
            else {
                //符合条件,偶数
                int l_max = Math.max(L1, L2), r_min = Math.min(R1, R2);
                //为奇数时,只需要取左中位点即可(而左中位点在L1和L2中取得,谁大取出)
                return count % 2 == 0 ? (l_max + r_min) / (double) 2 : (double) l_max;
            }
        }
        return 0.0;
    }


    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        return 0.0;
    }

    public static double findKth(int[] nums1, int o1, int[] nums2, int o2, int k) {
        return 0.0;
    }


    public static void main(String[] args) {
        int[] nums1 = {1, 2}, nums2 = {3, 4, 5, 6};
        double result = findMedianSortedArrays(nums1, nums2);
        System.out.println(result);

    }
}
