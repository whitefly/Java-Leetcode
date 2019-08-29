package 位运算;

public class Q342_power_of_four {
    public boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        int even = num & 0xaaaaaaaa;
        int rest = num & 0x55555555;
        if (even != 0) return false;
        return (rest & (rest - 1)) == 0;
    }

    public static void main(String[] args) {
        Q342_power_of_four s = new Q342_power_of_four();
        System.out.println(s.isPowerOfFour(17));
    }
}
