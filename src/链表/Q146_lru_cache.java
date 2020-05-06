package 链表;

import jdk.internal.org.objectweb.asm.tree.IincInsnNode;
import sun.awt.image.ImageWatched;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class Q146_lru_cache {
    int capacity;
    LinkedList<Integer> list;
    Map<Integer, Integer> map;


    public Q146_lru_cache(int capacity) {
        this.capacity = capacity;
        list = new LinkedList<>();
        map = new HashMap<>();
    }


    public int get(int key) {
        //Map中获取key
        int result = -1;
        Integer intKey = key;
        if (map.containsKey(key)) {
            //若存在,放在最前
            result = map.get(key);
            list.remove(intKey);
            list.addFirst(intKey);
        }
        return result;
    }

    public void put(int key, int value) {
        Integer intKey = key;
        if (!map.containsKey(key)) {
            //不存在,新增
            if (list.size() >= capacity) {
                //删除未使用的
                Integer del = list.removeLast();
                map.remove(del);
            }
        } else {
            //若存在,元素提前
            list.remove(intKey);
        }
        list.addFirst(intKey);
        map.put(intKey, value);
    }

    public static void main(String[] args) {
        Q146_lru_cache cache = new Q146_lru_cache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // 返回  1
        cache.put(3, 3);    // 该操作会使得密钥 2 作废
        System.out.println(cache.get(2));       // 返回 -1 (未找到)
        cache.put(4, 4);    // 该操作会使得密钥 1 作废
        System.out.println(cache.get(1));       // 返回 -1 (未找到)
        System.out.println(cache.get(3));       // 返回  3
        System.out.println(cache.get(4));       // 返回  4
    }
}
