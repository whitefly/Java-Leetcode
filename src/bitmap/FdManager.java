package bitmap;

import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;

/**
 * 实现文件描述符中的open和close操作,
 * open要求并返回第一个未使用的文件描述符
 */
public class FdManager {
    private BitSet bitSet;
    private Map<Integer, String> pathMapping;

    public FdManager(Integer count) {
        bitSet = new BitSet(count);
        pathMapping = new HashMap<>();
    }

    public Integer open(String filePath) {
        synchronized (this) {
            int i = bitSet.nextClearBit(0);
            pathMapping.put(i, filePath);
            bitSet.set(i);
            return i;
        }
    }

    public String close(Integer fd) {
        synchronized (this) {
            bitSet.clear(fd);
            return pathMapping.remove(fd);
        }
    }

    public String getPath(Integer fd) {
        return pathMapping.get(fd);
    }

    public static void main(String[] args) {
        FdManager fdManager = new FdManager(60000);

        String path1 = "~/hello1.txt";
        Integer open1 = fdManager.open(path1);
        System.out.println("open " + path1 + " fd: " + open1);

        String path2 = "~/hello2.txt";
        Integer open2 = fdManager.open(path2);
        System.out.println("open " + path2 + " fd: " + open2);

        String path3 = "~/hello3.txt";
        Integer open3 = fdManager.open(path3);
        System.out.println("open " + path3 + " fd: " + open3);

        fdManager.close(open2);
        System.out.println("close " + open2);


        String path4 = "~/hello4.txt";
        Integer open4 = fdManager.open(path4);
        System.out.println("open " + path4 + " fd: " + open4);

        String path = fdManager.getPath(open3);
        System.out.println("get " + open3 + "  path: " + path);

        long i = 8L ; //预期为3
        int i1 = Long.numberOfTrailingZeros(i);
        System.out.println(i1);
    }
}
