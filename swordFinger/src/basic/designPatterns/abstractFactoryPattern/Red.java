package basic.designPatterns.abstractFactoryPattern;

public class Red implements Color {
    @Override
    public void fill() {
        System.out.println("红色");
    }
}
