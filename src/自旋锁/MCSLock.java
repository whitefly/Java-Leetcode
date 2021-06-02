package 自旋锁;

import java.util.concurrent.atomic.AtomicReference;

public class MCSLock implements SpinLock {
    //    /*
//    全局有1个队列
//    每个线程读属于自己的变量
//     */
    static class QNode {
        volatile boolean locked;
        volatile QNode next;
    }


    //自旋队列
    private final AtomicReference<QNode> queue = new AtomicReference<>(null);

    //每个线程独有的node
    private final ThreadLocal<QNode> tNode = ThreadLocal.withInitial(QNode::new);


    @Override
    public void lock() {
        //将本线程节点加入到尾部
        QNode n = tNode.get();
        QNode m = queue.getAndSet(n);
        if (m != null) {
            n.locked = true;
            m.next = n;
            //开始自旋
            while (n.locked) {
            }
        }

    }

    @Override
    public void unlock() {
        QNode n = tNode.get();

        //一般unlock的第1个,需要将next的locked设置为false.需要处理next为空的情况
        if (n.next == null) {
            //若队列只有自己一个,将队列置空,退出即可
            if (queue.compareAndSet(n, null)) {
                return;
            }

            //若失败,说明自己不再唯一,在这3行代码中途可能有新节点突然设置queue队尾(可能只设置了queue变量,但还没有完全加入到链中)
            //本节点自旋到它完全加入到链中即可(即节点的next打通)
            while (n.next == null) {
            }
        }
        n.next.locked = false;
        n.next = null; //帮助gc
    }
}
