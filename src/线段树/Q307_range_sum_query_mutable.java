package 线段树;

import java.util.Arrays;

public class Q307_range_sum_query_mutable {
    /*
    线段树的构建,更新和查询
     */
    static class SegmentNode {
        private int start;
        private int end;
        private int sum;
        private SegmentNode left;
        private SegmentNode right;

        public SegmentNode(int start, int end, int sum) {
            this(start, end, sum, null, null);
        }

        public SegmentNode(int start, int end, int sum, SegmentNode left, SegmentNode right) {
            this.start = start;
            this.end = end;
            this.sum = sum;
            this.left = left;
            this.right = right;
        }
    }

    static class NumArray {
        SegmentNode root;
        int[] nums;
        int[] sums;
        /*
        解法1: 线段树
         */
//        public NumArray(int[] nums) {
//            this.nums = nums;
//            if (nums.length != 0) root = build(0, nums.length - 1);
//        }

//        public void update(int i, int val) {
//            updateTree(root, i, val);
//        }
//
//        public int sumRange(int i, int j) {
//            return querySum(root, i, j);
//        }
//
//        private SegmentNode build(int start, int end) {
//            if (start == end) return new SegmentNode(start, end, nums[start]);
//
//            int mid = (start + end) / 2;
//            SegmentNode L = build(start, mid);
//            SegmentNode R = build(mid + 1, end);
//            return new SegmentNode(start, end, L.sum + R.sum, L, R);
//        }
//
//        private void updateTree(SegmentNode root, int index, int val) {
//            if (root.start == index && root.end == index) {
//                root.sum = val;
//                return;
//            }
//            int mid = (root.start + root.end) / 2;
//            if (index <= mid) updateTree(root.left, index, val);
//            else updateTree(root.right, index, val);
//            root.sum = root.left.sum + root.right.sum;
//        }
//
//        private int querySum(SegmentNode root, int i, int j) {
//            if (root.start == i && root.end == j) return root.sum;
//
//            int mid = (root.start + root.end) / 2;
//            if (j <= mid) {
//                return querySum(root.left, i, j);
//            } else if (i > mid) {
//                return querySum(root.right, i, j);
//            } else return querySum(root.left, i, mid) + querySum(root.right, mid + 1, j);
//        }

        /*
        解法2: 树状数组
         */
        public NumArray(int[] nums) {
            this.nums = nums;
            this.sums = new int[nums.length + 1];
            //初始化树状数组
            for (int i = 0; i < nums.length; i++) updateArray(i, nums[i]);
        }

        private int lowBits(int x) {
            return x & -x;
        }

        private void updateArray(int i, int delta) {
            for (int l = i + 1; l < sums.length; l += lowBits(l)) sums[l] += delta;
        }

        private int sumArray(int i) {
            int result = 0;
            for (int l = i + 1; l > 0; l -= lowBits(l)) result += sums[l];
            return result;
        }

        public void update(int i, int val) {
            updateArray(i, val - nums[i]);
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return sumArray(j) - sumArray(i - 1);
        }

    }

    public static void main(String[] args) {
//        int[] nums = {1, 3, 5};
//        NumArray s = new NumArray(nums);
//        System.out.println(s.sumRange(0, 2));
//        s.update(1, 2);
//        System.out.println(s.sumRange(0, 2));

        int[] nums = {7, 2, 7, 2, 0};
        NumArray s = new NumArray(nums);
        System.out.println("初始化");
        System.out.println(Arrays.toString(s.sums));

        s.update(4, 6);
        System.out.println("执行s.update(4, 6);");
        System.out.println(Arrays.toString(s.sums));

        s.update(0, 2);
        System.out.println("s.update(0, 2);");
        System.out.println(Arrays.toString(s.sums));

        s.update(0, 9);
        System.out.println("s.update(0, 9);");
        System.out.println(Arrays.toString(s.sums));

        System.out.println(s.sumRange(4, 4));

        s.update(3, 8);
        System.out.println("执行s.update(3, 8);");
        System.out.println(Arrays.toString(s.sums));

        System.out.println(s.sumRange(0, 4));
        s.update(4, 1);
        System.out.println("执行 s.update(4, 1);");
        System.out.println(Arrays.toString(s.sums));

        System.out.println(s.sumRange(0, 3));
        System.out.println(s.sumRange(0, 4));
        s.update(0, 4);


    }
}
