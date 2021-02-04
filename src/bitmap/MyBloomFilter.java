package bitmap;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class MyBloomFilter {
    private final int k; //hash的次数
    private byte[] bitArray; //位
    private int bitLen; // bit位的总长度
    private final int keyBitCount; //每个key所占据的bit数量

    public MyBloomFilter(int k, int keyBitCount) {
        this.k = k;
        this.keyBitCount = keyBitCount;
    }

    public byte[] generate(byte[][] ketSet) {
        //得到bitLen的长度
        bitLen = getLen(ketSet.length);
        bitArray = new byte[bitLen >> 3];

        for (byte[] key : ketSet) {
            int h = Arrays.hashCode(key);
            //k次hash函数
            for (int i = 0; i < k; i++) {
                int idx = (h % bitLen + bitLen) % bitLen; //处理特殊情况: h可能为负数
                bitArray[idx / 8] |= (1 << (idx % 8));
                h = nextHash(h);
            }
        }
        return bitArray;
    }

    public static int nextHash(int h) {
        int delta = (h >> 17) | (h << 15); //hash旋转;
        h += delta;
        return h;
    }

    public int getLen(int keyCount) {
        int len = keyCount * keyBitCount;
        //向上得到8的倍数(最适用的算法为 K*N/ln2,k为hash次数,N为集合个数,这里用最简单的向上取倍数);
        len = ((len + 7) >> 3) << 3;
        return Math.max(len, 64);
    }

    public boolean contains(byte[] key) {
        int h = Arrays.hashCode(key);
        for (int i = 0; i < k; i++) {
            int idx = (h % bitLen + bitLen) % bitLen; //处理情况: h可能为负数
            if ((bitArray[idx >> 3] & (1 << (idx % 8))) == 0) {
                return false;
            }
            h = nextHash(h);
        }
        return true;
    }

//    public static String[] readWords(String path) {
//        try (final BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
//            final List<String> collect = bufferedReader.lines().collect(Collectors.toList());
//            return collect.toArray(new String[0]);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//    public static void main(String[] args) {
//        String wordPath = "/Users/zhouang/IdeaProjects/leetcode_java/src/bitmap/words.txt";
//        String testPath = "/Users/zhouang/IdeaProjects/leetcode_java/src/bitmap/test.txt";
//        final String[] words = readWords(wordPath);
//        final String[] test = readWords(testPath);
//        assert words != null;
//        assert test != null;
//
//        Set<String> all = new HashSet<>(Arrays.asList(words));
//
//        MyBloomFilter myBloomFilter = new MyBloomFilter(6, 4);
//        byte[][] input = new byte[words.length][];
//        for (int i = 0; i < input.length; i++) {
//            input[i] = words[i].getBytes();
//        }
//        myBloomFilter.generate(input);
//
//
//        for (String word : test) {
//            if (myBloomFilter.contains(word.getBytes())) {
//                System.out.println(word + " 可能存在  是否存在set:" + all.contains(word));
//            } else {
//                System.out.println(word + " 一定不存在 是否存在set:" + all.contains(word));
//            }
//        }
//    }
}
