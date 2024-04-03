package factory_method;

public class FactoryTest {
    public static void main(String[] args) {
        // Создание экземпляра ConcreteCreator
        Creator creator = new ConcreteCreator();
        // Вызов метода anOperation на созданном объекте ConcreteCreator
        creator.anOperation();
    }
}
