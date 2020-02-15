package test.thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosophersProblem {
}


class Chopstick {
    private Lock lock;
    private int number;

    public Chopstick(int n) {
        lock = new ReentrantLock();
        this.number = n;
    }

    public void pickUp() {
        lock.lock();
    }

    public void putDown() {
        lock.unlock();
    }

    public int getNumber(){
        return number;
    }
}

class Philosopher extends Thread {
    private int bites = 10;
    private Chopstick lower, higher;
    private int index;

    public Philosopher(int i, Chopstick left, Chopstick right) {
        index = i;
        if (left.getNumber() < right.getNumber()) {
            this.lower = left;
            this.higher = right;
        }else{
            this.lower = right;
            this.higher = left;
        }
    }

    public void eat() {
        pickUp();
        chew();
        putDown();
    }

    public void pickUp() {
        lower.pickUp();
        higher.pickUp();
    }

    public void chew() {
        System.out.println("yammy");
    }

    public void putDown() {
        higher.putDown();
        lower.putDown();
    }

    public void run() {
        for (int i = 0; i < bites; i++) {
            eat();
        }
    }
}