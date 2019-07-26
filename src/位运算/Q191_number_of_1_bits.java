package 位运算;

public class Q191_number_of_1_bits {
    public int hammingWeight(int n) {
        /*
        思入: 利用左移操作,将每位都依次移动到个位上
         */
        int count = 0;
        for (int i = 0; i < 32 && n != 0; i++) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeight2(int n) {
        /*
        思入: 使用n&(n-1),将最右边的1变为0, 每次变化一下,若整体不是0,就继续对右边的1进行变化.
         */
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 0b11111111111111111111111111111111;
        int b = 0xffffffff;
        System.out.println("a:" + a); // -1
        System.out.println("b:" + b); // -1
    }
}
