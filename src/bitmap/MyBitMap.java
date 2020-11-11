package bitmap;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;

import java.util.BitSet;

public class MyBitMap {
    int[] bigArray;

    public MyBitMap(long size) {
        //size表示用来表示
        this.bigArray = new int[(int) (size / 32 + 1)];
    }

    public void set0(int num) {
        if (num < 0) throw new ValueException("不能小于0");
        int arrayIndex = num >> 5;
        bigArray[arrayIndex] &= ~(1 << num);  //将出这位的其他位都设置为0,只需要翻转即可
    }

    public void set1(int num) {
        if (num < 0) throw new ValueException("不能小于0");
        int arrayIndex = num >> 5;
        bigArray[arrayIndex] |= 1 << num;
    }

    public boolean exist(int num) {
        int arrayIndex = num >> 5;
        return (bigArray[arrayIndex] & (1 << num)) != 0;
    }

    public String showBitMap() {
        StringBuilder sb = new StringBuilder();
        for (int i : bigArray) {
            for (int j = 0; j < 32; j++) {
                int bit = (i >>> j) & 1;
                sb.append(bit);
            }
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] arrays = new int[]{1, 2, 35, 22, 56, 334, 245, 54};

        MyBitMap bigMapTest = new MyBitMap(500);

        for (int i : arrays) {
            bigMapTest.set1(i);
        }
        System.out.println(bigMapTest.exist(36));
        System.out.println(bigMapTest.exist(35));
        System.out.println(bigMapTest.showBitMap());


        //jdk自带的BitSet的使用
        BitSet bitSet = new BitSet(500);
        for (int i : arrays) {
            bitSet.set(i);
        }
        System.out.println(bitSet.get(36));
        System.out.println(bitSet.get(35));
    }
}
