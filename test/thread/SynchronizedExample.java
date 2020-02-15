package test.thread;

public class SynchronizedExample {
    public static void main(String[] args) {

        // 서로 다른 MyObject객체인 경우 동시에 MyObject.foo()호출이 가능하다.
        MyObject sample1 = new MyObject();
        MyObject sample2 = new MyObject();

//        MyThreadClass instance1 = new MyThreadClass(sample1, "1");
//        MyThreadClass instance2 = new MyThreadClass(sample2, "2");

        // 같은 객체인 경우 하나만 foo를 호출할수 있다
        MyThreadClass instance1 = new MyThreadClass(sample1, "1");
        MyThreadClass instance2 = new MyThreadClass(sample1, "2");

        instance1.start();
        instance2.start();

    }
}

class MyThreadClass extends Thread {
    private String name;
    private MyObject myObj;

    public MyThreadClass(MyObject obj, String n) {
        name = n;
        myObj = obj;
    }

    public void run() {
        if ("1".equals(name)) {
            myObj.foo(name);
        } else {
            myObj.boo(name);
        }
    }
}

class MyObject {
    public static synchronized void foo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting..");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending.");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }

    public static synchronized void boo(String name) {
        try {
            System.out.println("Thread " + name + ".foo(): starting..");
            Thread.sleep(3000);
            System.out.println("Thread " + name + ".foo(): ending.");
        } catch (InterruptedException exc) {
            System.out.println("Thread " + name + ": interrupted.");
        }
    }
}
