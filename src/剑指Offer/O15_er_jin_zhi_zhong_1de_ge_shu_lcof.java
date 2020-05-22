package 剑指Offer;

public class O15_er_jin_zhi_zhong_1de_ge_shu_lcof {
    public static int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num = 0b00000000000000000000000000001011;
        System.out.println(hammingWeight(num));
    }
}
