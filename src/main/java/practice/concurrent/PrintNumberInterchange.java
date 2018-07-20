package practice.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用两个线程交替打印0~100
 *
 * @author lh
 * @date 2018/6/26
 */
public class PrintNumberInterchange {

    private final Lock lock = new ReentrantLock();
    /**
     * 奇数
     */
    private final Condition odd = lock.newCondition();

    /**
     * 偶数
     */
    private final Condition even = lock.newCondition();
    private volatile int number = 0;

    /**
     * 打印奇数
     */
    public void printOdd() {
        while (number < 100) {
            lock.lock();
            try {
                while (number % 2 != 1)
                    odd.await();
                System.out.println(number++);
                even.signal();
                //odd.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    /**
     * 打印偶数
     */
    public void printEven() {
        while (number < 100) {
            lock.lock();
            try {
                while (number % 2 != 0)
                    even.await();
                System.out.println(number++);
                odd.signal();
               //even.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

    }

    public static void main(String[] args) {
        PrintNumberInterchange instance = new PrintNumberInterchange();
        new Thread(() -> instance.printEven()).start();
        new Thread(() -> instance.printOdd()).start();
    }

}
