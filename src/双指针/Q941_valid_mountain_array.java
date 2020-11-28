package 双指针;

public class Q941_valid_mountain_array {
    public boolean validMountainArray(int[] arr) {
        if (arr == null || arr.length < 3) return false;
        int L = 0;
        int R = arr.length - 1;
        // ->
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) L = i;
            else break;
        }

        // <-
        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) R = i;
            else break;
        }
        return L == R && L != 0 && L != arr.length - 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Q941_valid_mountain_array solver = new Q941_valid_mountain_array();
        System.out.println(solver.validMountainArray(nums));
    }
}
