package 自旋锁;

public class TestLock {
    /**
     * 自旋锁的三种实现.
     * 不知道是不是测试有问题,在线程开到8之后,很大概率空转.但是逻辑实现感觉并没有问题o(╥﹏╥)o
     * 先放在这里,只简单了解
     */
    static long sum = 0;
    static long loopSize = 100000;
    static int threadNum = 8;

    public static void main(String[] args) throws InterruptedException {
//        SpinLock lock = new TASLock();
//        SpinLock lock = new TicketLock();
        SpinLock lock = new MCSLock();

        Runnable run = () -> {
            long time = loopSize;
            while (time > 0) {
                lock.lock();
                time--;
                sum++;
                lock.unlock();
            }
        };


        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threadNum; i++) {
            threads[i] = new Thread(run);
            threads[i].start();
        }

        for (Thread t : threads) {
            t.join();
        }

        System.out.println(sum);
    }
}
