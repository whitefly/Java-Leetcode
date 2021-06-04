package 多线程;

import java.util.concurrent.Semaphore;

public class Q1195_fizz_buzz_multithreaded {
    static class IntConsumer {
        void accept(int x) {
            System.out.println(x);
        }
    }

    static class FizzBuzz {
        private int n;
        volatile private int current = 1;
        volatile private boolean stopFlag = false;
        private Semaphore fizzSignal = new Semaphore(0);
        private Semaphore buzzSignal = new Semaphore(0);
        private Semaphore fizzBuzzSignal = new Semaphore(0);
        private Semaphore otherSignal = new Semaphore(1);


        public FizzBuzz(int n) {
            this.n = n;
        }

        // printFizz.run() outputs "fizz".
        public void fizz(Runnable printFizz) throws InterruptedException {
            while (current <= n) {
                fizzSignal.acquire();
                if (stopFlag) break;
                printFizz.run();
                notifyThreadAndPlus();
            }
        }

        // printBuzz.run() outputs "buzz".
        public void buzz(Runnable printBuzz) throws InterruptedException {
            while (current <= n) {
                buzzSignal.acquire();
                if (stopFlag) break;
                printBuzz.run();
                notifyThreadAndPlus();
            }
        }

        // printFizzBuzz.run() outputs "fizzbuzz".
        public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
            while (current <= n) {
                fizzBuzzSignal.acquire();
                if (stopFlag) break;
                printFizzBuzz.run();
                notifyThreadAndPlus();
            }
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void number(IntConsumer printNumber) throws InterruptedException {
            while (current <= n) {
                otherSignal.acquire();
                if (stopFlag) break;
                printNumber.accept(current);
                notifyThreadAndPlus();
            }
        }

        private void notifyThreadAndPlus() {
            current++;
            if (current > n) {
                stopFlag = true;
                fizzBuzzSignal.release();
                fizzSignal.release();
                buzzSignal.release();
                otherSignal.release();
            }
            boolean go3 = (current % 3) == 0;
            boolean go5 = (current % 5) == 0;
            if (go3 && go5) {
                fizzBuzzSignal.release();
            } else if (go3) {
                fizzSignal.release();
            } else if (go5) {
                buzzSignal.release();
            } else {
                otherSignal.release();
            }

        }
    }

    public static void main(String[] args) {
        FizzBuzz demo = new FizzBuzz(15);
        Thread thread_fizz = new Thread(() -> {
            try {
                demo.fizz(() -> System.out.println("fizz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread_buzz = new Thread(() -> {
            try {
                demo.buzz(() -> System.out.println("buzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread_fizzbuzz = new Thread(() -> {
            try {
                demo.fizzbuzz(() -> System.out.println("fizzbuzz"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        IntConsumer intConsumer = new IntConsumer();

        Thread thread_other = new Thread(() -> {
            try {
                demo.number(intConsumer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread_fizz.start();
        thread_buzz.start();
        thread_fizzbuzz.start();
        thread_other.start();


    }
}
