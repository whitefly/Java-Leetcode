package 哈希;

public class Q299_bulls_and_cows {
    public String getHint(String secret, String guess) {
        /**
         * 思入: 扫一遍,记录正确的位置, 2个map, 然后遍历第一个map即可
         */
        int[] map1 = new int[10];
        int[] map2 = new int[10];
        int A = 0;
        int B = 0;
        char[] chars1 = secret.toCharArray();
        char[] chars2 = guess.toCharArray();
        for (int i = 0; i < secret.length(); i++) {
            if (chars1[i] == chars2[i]) A++;
            else {
                map1[chars1[i] - '0']++;
                map2[chars2[i] - '0']++;
            }
        }
        //计算剩余的
        for (int i = 0; i < map1.length; i++) B += Math.min(map1[i], map2[i]);
        return String.format("%dA%dB", A, B);
    }

    public static void main(String[] args) {
        Q299_bulls_and_cows s = new Q299_bulls_and_cows();
        String secret = "1123";
        String guess = "0111";
        System.out.println(s.getHint(secret, guess));
    }

}
