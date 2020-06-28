package cn.mrhan.study.demo.demos;

/**
 * 关于死锁
 */
public class Demo05 {
    static Object resource1 = new Object(), resource2 = new Object();

    public static void main(String[] args) {

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource1){
                    System.out.println("resource1");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource2){
                    System.out.println("resource2================2");
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (resource2){
                    System.out.println("resource2");
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (resource1){
                    System.out.println("resource1================1");
                }
            }
        });
        t1.start();
        t2.start();
    }
}
