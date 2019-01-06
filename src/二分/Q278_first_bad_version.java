package 二分;

public class Q278_first_bad_version {

    boolean isBadVersion(int version) {
        return false;
    }

    public int firstBadVersion(int n) {
        /**
         * 思入: 简单的二分查找,本质是找第一次出现的数
         */
        int l = 1, r = n;
        while (l < r) {
            int mid = l + (r - l) / 2;  //本题有溢出的可能
            if (isBadVersion(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        Q278_first_bad_version s = new Q278_first_bad_version();
        System.out.println(s.firstBadVersion(22));
    }
}
