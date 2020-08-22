package 多线程;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class Q1117_building_h2o {
    static class H2O {
        Semaphore semaphoreH = new Semaphore(2);
        Semaphore semaphoreO = new Semaphore(0);

        public H2O() {

        }

        public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
            semaphoreH.acquire();  //需要1个H的空盘子
            releaseHydrogen.run();
            semaphoreO.release();

        }

        public void oxygen(Runnable releaseOxygen) throws InterruptedException {
            semaphoreO.acquire(2);  //需要2个O的空盘
            releaseOxygen.run();
            semaphoreH.release(2);  //产生2个H的空盘
        }
    }
}
