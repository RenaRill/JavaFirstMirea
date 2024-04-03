package prototype;

// Метод для создания копии объекта типа ConcretePrototype2
public class ConcretePrototype2 implements Prototype{
    @Override
    public Prototype clone() {
        return new ConcretePrototype2();
    }
}
