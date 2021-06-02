package 自旋锁;


public interface SpinLock {
    /**
     * 通过一个全局变量
     */

    void lock();


    void unlock();


}
