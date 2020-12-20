package basic.juc.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MyCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("mycallable here");
        TimeUnit.SECONDS.sleep(4);
        return "1024";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new MyCallable());
        new Thread(futureTask,"A").start();

        System.out.println(Thread.currentThread().getName()+"...计算完成");
        System.out.println(futureTask.get());

    }
}
