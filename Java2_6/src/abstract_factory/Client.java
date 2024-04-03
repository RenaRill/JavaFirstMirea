package abstract_factory;

// Класс Client использует AbstractFactory для создания продуктов
public class Client {
    // Приватные поля для хранения продуктов
    private AbstractProduct productA;
    private AbstractProduct productB;

    public Client(AbstractFactory factory) {
        // Создание продуктов с помощью фабрики
        productA = factory.CreateProductA();
        productB = factory.CreateProductB();
    }

    // Метод для выполнения действий с продуктами
    public void run() {
        productA.doSomething();
        productB.doSomething();
    }
}
