package basic.juc.thread;

public class Mythread  extends  Thread {

    @Override
    public void run() {
        System.out.println("myThread run");
    }

    public static void main(String[] args) {
        Mythread mythread = new Mythread();
        mythread.start();
    }
}
