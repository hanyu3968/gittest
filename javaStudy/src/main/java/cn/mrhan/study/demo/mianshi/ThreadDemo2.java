package cn.mrhan.study.demo.mianshi;

public class ThreadDemo2 {
    public static void main(String[] args) {
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
               for(int i=0;i<10;i++){
                   System.out.println("==========="+i);
                   try {
                       Thread.sleep(1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }

               }
            }
        };

        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<10;i++){
                    System.out.println("***********"+i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }
        };
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();



    }

}
