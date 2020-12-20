package basic.juc.AQS;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class MySemaphore {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <= 7; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"号车停入停车场");
                    TimeUnit.SECONDS.sleep(2);
                    System.out.println(Thread.currentThread().getName()+"号车驶出停车场");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            },String.valueOf(i)).start();
        }
    }
}
