package basic.designPatterns.builderPattern;

public abstract class Burger implements Item {
    @Override
    public Packing packing() {
        return new Wrapper();
    }
}
