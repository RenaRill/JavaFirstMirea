package prototype;

public class Client {
    public static void main(String[] args) {
        // Создание объектов-прототипов
        Prototype prototype1 = new ConcretePrototype1();
        Prototype prototype2 = new ConcretePrototype2();

        // Клонирование объектов
        Prototype clonedPrototype1 = prototype1.clone();
        Prototype clonedPrototype2 = prototype2.clone();

        System.out.println(clonedPrototype1);
        System.out.println(clonedPrototype2);
    }
}
