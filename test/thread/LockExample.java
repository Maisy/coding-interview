package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExample {

    public static void main(String[] args) {
        LockedATM test = new LockedATM();
        ThreadLockExample tle = new ThreadLockExample(test);
        ThreadLockExample tle2 = new ThreadLockExample(test);
        tle.start();
        tle2.start();
    }
}


class ThreadLockExample extends Thread {
    LockedATM atm;

    ThreadLockExample(LockedATM atm) {
        this.atm = atm;
    }

    int count = 0;

    public void run() {
        System.out.println("Thread starting.");

        try {
            while (count < 5) {
                Thread.sleep(100);
                int rest = atm.deposit(1000);
                System.out.println(rest);
                rest = atm.withdraw(600);
                System.out.println(rest);
                System.out.println("In Thread, count is " + count);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("Thread interrupted.");
        }
        System.out.println("Thread terminating.");
    }

}

class LockedATM {
    private Lock lock;
    private int balance = 100;

    public LockedATM() {
        lock = new ReentrantLock();
    }

    public int withdraw(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp - value;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException exec) {

        }
        lock.unlock();
        return temp;
    }

    public int deposit(int value) {
        lock.lock();
        int temp = balance;
        try {
            Thread.sleep(100);
            temp = temp + value
            ;
            Thread.sleep(100);
            balance = temp;
        } catch (InterruptedException e) {

        }
        lock.unlock();
        return temp;
    }
}
