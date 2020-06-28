package cn.mrhan.study.demo.demos;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Method {

    public void start(){
        System.out.println("方法开始");
    }

    public void end(){
        System.out.println("方法结束");
    }


    public void domain(){
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("方法执行中..." + j);
                }
            }
        });


        executorService.execute(new Runnable() {
            @Override
            public void run() {
                for (int j = 0; j < 10; j++) {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("方法执行中2..." + j);
                }
            }
        });

        executorService.shutdown();
        while(!executorService.isTerminated()){

        }
    }

}
