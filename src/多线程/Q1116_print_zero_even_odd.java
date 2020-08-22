package 多线程;

import java.util.concurrent.Semaphore;

public class Q1116_print_zero_even_odd {
    static class IntConsumer {
        void accept(int x) {
            System.out.println(x);
        }
    }

    static class ZeroEvenOdd {
        Semaphore semaphore0 = new Semaphore(1);
        Semaphore semaphore1 = new Semaphore(0);
        Semaphore semaphore2 = new Semaphore(0);

        private int n;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                semaphore0.acquire();
                printNumber.accept(0);
                if ((i & 1) == 1) {
                    semaphore1.release();
                } else {
                    semaphore2.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            for (int i = 2; i <= n; i += 2) {
                semaphore2.acquire();
                printNumber.accept(i);
                semaphore0.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            for (int i = 1; i <= n; i += 2) {
                semaphore1.acquire();
                printNumber.accept(i);
                semaphore0.release();
            }
        }
    }
}
