package 自旋锁;

import java.util.concurrent.atomic.AtomicReference;

public class TASLock implements SpinLock {
    /*
    设置一个线程共有变量作为标志符
     */
    private final AtomicReference<Thread> ownThread = new AtomicReference<>();

    @Override
    public void lock() {
        Thread currentThread = Thread.currentThread();
        while (!ownThread.compareAndSet(null, currentThread)) {
        }
    }

    @Override
    public void unlock() {
        Thread currentThread = Thread.currentThread();
        ownThread.compareAndSet(currentThread, null);
    }
}
