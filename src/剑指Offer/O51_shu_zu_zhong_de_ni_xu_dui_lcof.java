package 剑指Offer;


public class O51_shu_zu_zhong_de_ni_xu_dui_lcof {
    int[] temp;

    public int reversePairs(int[] nums) {
        temp = new int[nums.length];
        return mergeSore(nums, 0, nums.length - 1);
    }

    int mergeSore(int[] nums, int L, int R) {
        int count = 0;
        if (L >= R) return count;
        int mid = (L + R) / 2;
        count += mergeSore(nums, L, mid);
        count += mergeSore(nums, mid + 1, R);
        //合并  [L,mid],[mid+1,R]
        int store = 0, lIndex = L, RIndex = mid + 1;
        while (lIndex <= mid && RIndex <= R) {
            if (nums[lIndex] > nums[RIndex]) {
                temp[store++] = nums[RIndex++];
                count += mid - lIndex + 1;  //添加逆序对
            } else {
                temp[store++] = nums[lIndex++];
            }
        }
        //某一部分可能到头,另一部分没有遍历完,复制没有遍历完的部分到temp
        if (lIndex > mid) {
            System.arraycopy(nums, RIndex, temp, store, R - RIndex + 1); //右边有剩余部分
        } else {
            System.arraycopy(nums, lIndex, temp, store, mid - lIndex + 1);
        }
        //将temp整体复制到nums;
        System.arraycopy(temp, 0, nums, L, R - L + 1);
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7, 5, 6, 4};
        O51_shu_zu_zhong_de_ni_xu_dui_lcof s = new O51_shu_zu_zhong_de_ni_xu_dui_lcof();
        int i = s.reversePairs(nums);
        System.out.println(i);
    }


}
