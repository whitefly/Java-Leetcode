package 剑指Offer;

public class O64_qiu_12n_lcof {
    public int sumNums(int n) {
        int temp = 0;
        boolean flag = (n > 1) && (temp = sumNums(n - 1)) >= 0;
        return temp + n;
    }

    public static void main(String[] args) {
        O64_qiu_12n_lcof s = new O64_qiu_12n_lcof();
        System.out.println(s.sumNums(9));
    }
}
