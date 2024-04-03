package visitor;

public class Client {
    public static void main(String[] args) {
        // Создаем массив элементов, которые будут посещены
        Element[] elements = new Element[]{new ConcreteElementA(), new ConcreteElementB()};

        // Создаем объект ConcreteVisitor, который будет посещать элементы
        Visitor visitor = new ConcreteVisitor();
        // Проходим по всем элементам и вызываем метод accept, передавая в него visitor
        for (Element element : elements) {
            element.accept(visitor);
        }
    }
}
