package basic.designPatterns.abstractFactoryPattern;


public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("矩形");
    }
}
