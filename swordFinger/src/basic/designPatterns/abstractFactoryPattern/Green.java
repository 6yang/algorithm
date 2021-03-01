package basic.designPatterns.abstractFactoryPattern;

public class Green implements Color {
    @Override
    public void fill() {
        System.out.println("绿色");
    }
}
