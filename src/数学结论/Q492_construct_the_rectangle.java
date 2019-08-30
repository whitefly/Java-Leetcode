package 数学结论;

import java.util.Arrays;

public class Q492_construct_the_rectangle {
    public int[] constructRectangle(int area) {
        int w = (int)Math.sqrt(area);
        while(area%w!=0){
            w--;
        }
        return new int[] {area/w,w};
    }

    public static void main(String[] args) {
        Q492_construct_the_rectangle s = new Q492_construct_the_rectangle();
        System.out.println(Arrays.toString(s.constructRectangle(10000000)));
    }
}
