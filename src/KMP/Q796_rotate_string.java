package KMP;

public class Q796_rotate_string {
    public boolean rotateString(String A, String B) {
        /*
        思入: 这种把2个字符串拼在一起的思入,感觉在很多地方都看见过
         */

        return A.length() == B.length() && (A + A).contains(B);
    }
}
