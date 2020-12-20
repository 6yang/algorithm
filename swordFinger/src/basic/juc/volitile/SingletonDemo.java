package basic.juc.volitile;

public class SingletonDemo {
    private static volatile SingletonDemo instance = null;
    private SingletonDemo(){
        System.out.println(Thread.currentThread().getName()+"构造方法");
    }

    public static SingletonDemo getInstance(){
        if(instance==null){
            synchronized (SingletonDemo.class){
                if(instance==null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
}
