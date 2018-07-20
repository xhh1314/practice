package practice.collection;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPrintAbc {



    public static void  main(String[] args){
        Operation operation=new Operation();
        Thread a=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    operation.printA();
                }
            }
        });
        a.setName("Thread A");
        Thread b=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    operation.printB();
                }
            }
        });
        b.setName("Thread B");
        Thread c=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    operation.printC();
                }
            }
        });
        c.setName("Thread C");

        a.start();
        b.start();
        c.start();



    }

    static class Operation {
        volatile String flag = "A";
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();


        void printA() {
            lock.lock();
            try {
                while (!flag.equals("A"))
                    conditionA.await();
                System.out.println("current thread:" + Thread.currentThread().getName() + ",val is A");
                flag="B";
                conditionB.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        void printB() {
            lock.lock();
            try {
                while (!flag.equals("B"))
                    conditionB.await();
                System.out.println("current thread:" + Thread.currentThread().getName() + ",val is B");
                flag="C";
                conditionC.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }

        void printC() {
            lock.lock();
            try {
                while (!flag.equals("C"))
                    conditionC.await();
                System.out.println("current thread:" + Thread.currentThread().getName() + ",val is C");
                flag="A";
                conditionA.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }


    }
}
