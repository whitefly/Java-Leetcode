package 字符串;

public class Q165_compare_version_numbers {
    public int compareVersion(String version1, String version2) {
        /**
         * 思入: 正则分离. 由于1.0001和1.1是等价的.所以要不1.1补0称为1.0001,要不1.0001去掉0变为1.1
         */
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        int size1 = nums1.length, size2 = nums2.length;
        int max = Math.max(size1, size2);
        for (int i = 0; i < max; i++) {
            String s1 = i < size1 ? simple_zero(nums1[i]) : "";
            String s2 = i < size2 ? simple_zero(nums2[i]) : "";

            int result = compare(s1, s2);
            if (result == -1) return -1;
            if (result == 1) return 1;
        }
        return 0;

    }

    private String simple_zero(String s) {
        int size = s.length();
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) != '0') return s.substring(i, size);
        }
        return "";
    }

    private int compare(String s1, String s2) {
        if (s1.length() < s2.length()) return -1;
        if (s1.length() > s2.length()) return 1;
        int size = s1.length();
        for (int i = 0; i < size; i++) {
            int c1 = s1.charAt(i), c2 = s2.charAt(i);
            if (c1 < c2) return -1;
            if (c1 > c2) return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String version1 = "1.01", version2 = "1.001";
        Q165_compare_version_numbers s = new Q165_compare_version_numbers();
        int i = s.compareVersion(version1, version2);
        System.out.println(i);
    }
}
