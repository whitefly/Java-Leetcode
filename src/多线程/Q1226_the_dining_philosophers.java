package 多线程;

import java.util.concurrent.Semaphore;

public class Q1226_the_dining_philosophers {
    static class DiningPhilosophers {
        //思入: 拿起左右的叉子应该是一个原子操作,额外加一个锁即可.缺点:每个时间只有一个哲学家吃饭,并发度低
        Semaphore mutex = new Semaphore(1);
        Semaphore[] forkLock;

        public DiningPhilosophers() {
            forkLock = new Semaphore[5];
            for (int i = 0; i < 5; i++) {
                forkLock[i] = new Semaphore(1);
            }
        }

        // call the run() method of any runnable to execute its code
        public void wantsToEat(int philosopher,
                               Runnable pickLeftFork,
                               Runnable pickRightFork,
                               Runnable eat,
                               Runnable putLeftFork,
                               Runnable putRightFork) throws InterruptedException {

            mutex.acquire();
            forkLock[philosopher].acquire();
            forkLock[(philosopher + 1) % 5].acquire();

            pickLeftFork.run();
            pickRightFork.run();
            eat.run();

            forkLock[(philosopher + 1) % 5].release();
            forkLock[philosopher].release();
            putLeftFork.run();
            putRightFork.run();
            mutex.release();
        }
    }
}
