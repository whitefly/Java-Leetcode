package IO;

import java.util.Arrays;

public class Q157_read_n_characters_given_read4 {

    int read4(char[] buf) {
        return 1;
    }

    public int read(char[] buf, int n) {
        char[] temp = new char[4];
        int size;
        int position = 0;
        while ((size = read4(temp)) != 0) {
            if (size + position <= n) {
                System.arraycopy(temp, 0, buf, position, size);
                position += size;
            } else {
                System.arraycopy(temp, 0, buf, position, n - position);
                return n;
            }
        }
        return position;
    }

}
