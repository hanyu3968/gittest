package cn.mrhan.study.demo.mianshi;

public class ThreadDemo {


    public static void main(String[] args) {
        Thread t3  = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("***********"+i);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };


        Thread t4  = new Thread(){
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("#############"+i);
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
/*        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();*/
        t3.start();
        t4.start();

    }
}

