package 堆;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable> {
    private List<T> container = new ArrayList<>();
    private boolean isSmall;

    /**
     * 默认小根堆
     */
    public Heap() {
        this(true);
    }

    public Heap(boolean small) {
        this.isSmall = small;
    }

    private int getParentIndex(int newIndex) {
        return (newIndex - 1) / 2;
    }

    private int getRightIndex(int newIndex) {
        return newIndex * 2 + 2;
    }

    private int getLeftIndex(int newIndex) {
        return newIndex * 2 + 1;
    }

    public boolean add(T item) {
        // 一个节点i的父节点下标为 (i-1)/2   左子: 2*i+1  右子: 2*i+2
        container.add(item);
        int newIndex = container.size() - 1;
        //开始移动位置
        while (newIndex > 0) {
            int parentIndex = getParentIndex(newIndex);
            T parent = container.get(parentIndex);
            if ((parent.compareTo(item) <= 0) == isSmall) break;
            //交换
            container.set(parentIndex, item);
            container.set(newIndex, parent);
            System.out.println("交换:" + item + "<->" + parent);
            newIndex = parentIndex;
        }
        return true;
    }


    public T remove() {
        if (container.isEmpty()) return null;
        T rnt = container.get(0);
        if (container.size() == 1) {
            container.remove(0);
            return rnt;
        }
        //将最后一个元素放在首位置
        T last = container.get(container.size() - 1);
        container.set(0, last);
        container.remove(container.size() - 1);

        int newIndex = 0;
        //开始调整下移
        while ((getLeftIndex(newIndex) < container.size())) {
            //抽取出左右子
            T target = container.get(newIndex);
            int leftIndex = getLeftIndex(newIndex), rightIndex = getRightIndex(newIndex);
            T left = leftIndex >= container.size() ? null : container.get(leftIndex);
            T right = rightIndex >= container.size() ? null : container.get(rightIndex);

            //无法下移的情况(这里需要考虑左,右子不存在的情况)
            if (left == null) break;
            if ((target.compareTo(left) <= 0) == isSmall && right == null) break;
            if ((target.compareTo(left) <= 0) == isSmall && (target.compareTo(right) <= 0) == isSmall)
                break;

            //一定会移动最小的,交换
            if (right == null) {
                container.set(newIndex, left);
                container.set(leftIndex, target);
                newIndex = leftIndex;
                System.out.println("交换:" + target + "<->" + left);
            } else {
                if ((left.compareTo(right) <= 0) == isSmall) {
                    container.set(newIndex, left);
                    container.set(leftIndex, target);
                    newIndex = leftIndex;
                    System.out.println("交换:" + target + "<->" + left);
                } else {
                    container.set(newIndex, right);
                    container.set(rightIndex, target);
                    newIndex = rightIndex;
                    System.out.println("交换:" + target + "<->" + right);
                }
            }
        }
        return rnt;
    }


    public static void main(String[] args) {
        Integer[] nums = {0, 10, 5, 4, 1, 11, 12, -1, 33, 22, 23, 5};
        Heap<Integer> heap = new Heap<>(false); //使用大根堆
        for (int num : nums) heap.add(num);
        System.out.println("全部加入完成");

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) result.add(heap.remove());
        System.out.println("堆排序完成");
        System.out.println(result);

    }
}
