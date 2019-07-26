package 位运算;

public class Q231_power_of_two {
    public boolean isPowerOfTwo(int n) {
    /*
     思入: 判断n的二进制是否只有一个1,使用一次n&(n-1),去掉一个1,若为0就说明只有一个1(即2个幂)
     */
        if (n > 0) return false;
        return (n & (n - 1)) == 0;
    }
}
