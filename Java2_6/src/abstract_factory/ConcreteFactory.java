package abstract_factory;

public class ConcreteFactory implements AbstractFactory{
    // Создание продуктов
    public AbstractProduct CreateProductA() {
        return new ConcreteProduct();
    }
    public AbstractProduct CreateProductB() {
        return new ConcreteProduct();
    }
}
