package 数学结论;

public class Q1551_minimum_operations_to_make_array_equal {
    public static int minOperations(int n) {
        //算出所有小于中间数和它的差值和即可
        return (n & 1) == 1 ? sum(2, 2, n / 2) : sum(1, 2, n / 2);
    }

    private static int sum(int a1, int d, int n) {
        return n * a1 + n * (n - 1) * d / 2;
    }

    public static void main(String[] args) {
        System.out.println(minOperations(6));

    }
}
