package 自旋锁;


import java.util.concurrent.atomic.AtomicInteger;

public class TicketLock implements SpinLock {
    /*
    ①一个原子变量用于取好
    ②一个原子遍历用于取号

    可以公平性
     */

    AtomicInteger bookingId = new AtomicInteger(0);
    AtomicInteger serviceId = new AtomicInteger(0);
    //    static ThreadLocal<Integer> threadBookId = new ThreadLocal<>();
    static volatile Integer lockedNO;

    @Override
    public void lock() {
        Integer id = bookingId.getAndIncrement();
        while (serviceId.get() != id) {
        }
        lockedNO = id;
    }

    @Override
    public void unlock() {
        serviceId.compareAndSet(lockedNO, lockedNO + 1);
    }

}

//public class TicketLock implements SpinLock {
//
//    /**
//     * 叫号的号码（排队号）
//     */
//    private final AtomicInteger SERVICE_NO = new AtomicInteger(-1);
//    /**
//     * 取号的号码（当前可以获取锁的号）
//     */
//    private final AtomicInteger CURRENT_SERVICE_NO = new AtomicInteger(0);
//    private volatile Integer lockedNO = -1;
//
//    @Override
//    public void lock() {
//        // 1. 取号
//        int number = SERVICE_NO.incrementAndGet();
//        // 2. 当前叫号与取号不匹配进入自旋
//        while (number != CURRENT_SERVICE_NO.get()) {
//        }
//        // 3. 当前叫号与取号匹配获取锁成功
//        // 4. 记录当前获取到所资源的编号，解锁时需要匹配，不能随便释放其他人的锁
//        lockedNO = number;
//    }
//
//    @Override
//    public void unlock() {
//        // 4. 释放锁，递增叫号唤醒下一个等待锁的排号者
//        CURRENT_SERVICE_NO.compareAndSet(lockedNO, lockedNO + 1);
////        System.out.println("release lock:SERVICE_NO=" + SERVICE_NO.get() + ",currentServiceNo=" + CURRENT_SERVICE_NO.get());
//    }
//}