package basic.generics;


import java.util.ArrayList;

public class genericsTest {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.getClass().getMethod("add",Object.class).invoke(list,"asd");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
