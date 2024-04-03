package factory_method;

// Реализация интерфейса Product - конкретный продукт
public class ConcreteProduct implements Product {

    // Реализация метода интерфейса
    public void doSomething() {
        System.out.println("Делаем что-то...");
    }
}
