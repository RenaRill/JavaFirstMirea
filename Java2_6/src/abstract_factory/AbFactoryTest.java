package abstract_factory;

public class AbFactoryTest {
    public static void main(String[] args) {
        // Создание объекта типа ConcreteFactory
        AbstractFactory factory = new ConcreteFactory();
        // Создание объекта класса Client с передачей фабрики
        Client client = new Client(factory);
        // Выполнение действий с продуктами
        client.run();
    }
}
