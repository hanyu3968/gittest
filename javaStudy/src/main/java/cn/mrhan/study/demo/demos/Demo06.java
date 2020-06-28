package cn.mrhan.study.demo.demos;
/**
 * 关于死锁
 */
public class Demo06 implements Runnable {
    private int flag = 1;
    static Object resource1 = new Object(), resource2 = new Object();
    public void run() {
        if (flag == 1) {
            synchronized (resource1) {
                System.out.println("resource1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (resource2) {
                    System.out.println("resource2");
                }
            }
        }
        if (flag == 0) {
            synchronized (resource2) {
                System.out.println("resource2");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                }
                synchronized (resource1) {
                    System.out.println("resource1");
                }
            }
        }
    }

    public static void main(String[] args) {
        Demo06 lock1 = new Demo06();
        Demo06 lock2 = new Demo06();
        lock1.flag = 1;
        lock2.flag = 0;
        Thread t1 = new Thread(lock1);
        Thread t2 = new Thread(lock2);
        t1.start();
        t2.start();
    }
}
