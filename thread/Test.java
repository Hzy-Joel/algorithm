package thread;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/***
 * volatile 保证每次取得的值都是最新的
 * 
 * synchronized保证操作的原子性，在进行对变量的操作时不被其他线程进入，当该线程打印完之后其他线程就可以由volatile保证取得最新值
 * 
 */

class Test {

    public static void main(String[] args) {
        Test test = new Test();
        test.test2();
    }

    public volatile Integer count = 0;

    public Boolean running = true;

    public synchronized void add() {
        count++;
    }

    public void test1() {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(200);
                        add();
                        System.out.println(Thread.currentThread() + "" + count);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }

            }
        }, "thread-1");

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    try {
                        Thread.sleep(200);
                        add();
                        System.out.println(Thread.currentThread() + "" + count);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                }
            }
        }, "thread-2");

        thread1.start();
        thread2.start();
    }

    /***
     * 交替打印num
     * 
     * 当调用wait之后会进入锁的等待池中，不会参与锁的竞争、直到被notify唤醒
     * 
     */
    public AtomicInteger num = new AtomicInteger(0);

    public void test2() {
        Thread thread1;
        Thread thread2;
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Object lock = new Object();
        thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch.countDown();
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        try {
                            // 获得锁进入
                            lock.notify(); // 唤醒等待池中的线程参与竞争
                            System.out.println(Thread.currentThread() + " " + num.addAndGet(1));
                            lock.wait(); // 进入等待
                            lock.notify(); // 被其他线程notify唤醒后走到这
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                }
            }
        }, "thread-1");

        thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch.await();
                } catch (Exception e) {

                }
                synchronized (lock) {
                    for (int i = 0; i < 10; i++) {
                        try {

                            // 获得锁进入
                            lock.notify(); // 唤醒等待池中的线程参与竞争
                            System.out.println(Thread.currentThread() + " " + num.addAndGet(1));
                            lock.wait(); // 进入等待
                            lock.notify(); // 被其他线程notify唤醒后走到这
                        } catch (Exception e) {
                            // TODO: handle exception
                        }

                    }
                }

            }
        }, "thread-2");

        thread1.start();
        thread2.start();
    }

}