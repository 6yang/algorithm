package basic.designPatterns.singleton;

public class Singleton {
    private volatile static Singleton singleton;

    private Singleton(){}

    public Singleton getSingleton(){
        if(singleton== null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}
