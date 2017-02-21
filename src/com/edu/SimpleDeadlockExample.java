package com.edu;

/**
 * Created by denis on 21.02.2017.
 */
public class SimpleDeadlockExample {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void doDeadLock() {
        Thread t1 = new A();
        Thread t2 = new B();
        t1.start();
        t2.start();
    }

    private class A extends Thread {
        public void run() {
            synchronized (lock1) {
                System.out.println("Thread 1: Holding lock 1...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 1: Waiting for lock 2...");
                synchronized (lock2) {
                    System.out.println("Thread 2: Holding lock 1 & 2...");
                }
            }
        }
    }
    private class B extends Thread {
        public void run() {
            synchronized (lock2) {
                System.out.println("Thread 2: Holding lock 2...");
                try { Thread.sleep(10); }
                catch (InterruptedException e) {}
                System.out.println("Thread 2: Waiting for lock 1...");
                synchronized (lock1) {
                    System.out.println("Thread 2: Holding lock 2 & 1...");
                }
            }
        }
    }
}
