package 位运算;

public class Q137_single_number_ii {
    public int singleNumber(int[] nums) {
        /**
         * 思入: 每个bit的状态会出现0,1,2. 用单个位无法表示3种状态
         * 至少需要2位来表示,所以引入A和B来共同表示状态
         * 画出真值表图(最小项法),得出逻辑表达式 A=A'BC+AB'C'  B=A'B'C'+A'BC'=A'(B xor C)  其中A'表示A的非(即~A)
         */

        int A = 0, B = 0;
        for (int C : nums) {
            int tempA = (~A & B & C) | (A & ~B & ~C);
            B = (~A & ~B & C) | (~A & B & ~C);
            A = tempA;
        }
        return B;
    }

    public int singleNumber2(int[] nums) {
        /**
         * 思入2:  设计k个位,来表示k种状态
         */
        int m = 3;
        int n = 1;
        int[] sizeBits = new int[m + 1];
        sizeBits[0] = -1;
        for (int c : nums) {
            //更新数字位
            for (int i = m; i >= 1; i--) sizeBits[i] ^= sizeBits[i - 1] & c;
            int mask = sizeBits[m];
            //修正状态位,保证完整正确
            for (int i = m; i >= 1; i--) sizeBits[i] &= (~mask);
        }
        return sizeBits[n];
    }

    public static void main(String[] args) {
//        int[] nums = {2, 2, 3, 2, 3, 3, 99};
        int[] nums = {3, 3, 3, 1};
        Q137_single_number_ii s = new Q137_single_number_ii();
        int i = s.singleNumber2(nums);
        System.out.println(i);
    }

}
