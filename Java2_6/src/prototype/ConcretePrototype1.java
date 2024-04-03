package prototype;

// Метод для создания копии объекта типа ConcretePrototype1
public class ConcretePrototype1 implements Prototype{
    @Override
    public Prototype clone() {
        return new ConcretePrototype1();
    }
}
