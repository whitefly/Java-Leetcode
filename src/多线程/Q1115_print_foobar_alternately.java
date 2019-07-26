package 多线程;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Q1115_print_foobar_alternately {
    static class FooBar {
        static Semaphore s1 = new Semaphore(0);
        static Semaphore s2 = new Semaphore(0);
        private int n;

        public FooBar(int n) {
            this.n = n;
        }


        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printFoo.run() outputs "foo". Do not change or remove this line.


                printFoo.run();
                s2.release(1);
                s1.acquire(1);

            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {

                // printBar.run() outputs "bar". Do not change or remove this line.
                s2.acquire(1);
                printBar.run();
                s1.release(1);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        FooBar s = new FooBar(2);
    }
}
