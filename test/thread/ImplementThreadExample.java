package test.thread;

public class ImplementThreadExample {

    public static void main(String[] args) {
        RunnableThreadExample instance = new RunnableThreadExample();
        // Thread를 생성할때 runnable을 인자로 넘긴다.
        Thread thread = new Thread(instance);
        thread.start();

        // thread 가 5개가 될때까지 기다린다.
        while (instance.count != 5) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException exc) {
                exc.printStackTrace();
            }
        }
    }
}

class RunnableThreadExample implements Runnable {
    public int count = 0;

    @Override
    public void run() {
        System.out.println("Runnable Thread starting...");
        try {
            while (count < 5) {
                Thread.sleep(500);
                System.out.println("count: " + count);
                count++;
            }
        } catch (InterruptedException exc) {
            System.out.println("Runnable thread interrupted.");
        }
        System.out.println("RunnableThread terminating.");
    }
}
