package visitor;

// Класс ConcreteVisitor реализует интерфейс Visitor и определяет логику работы с элементами
public class ConcreteVisitor implements Visitor{
    @Override
    public void visitElementA(ConcreteElementA a) {
        System.out.println("Посещение элемента A");
    }

    @Override
    public void visitElementB(ConcreteElementB b) {
        System.out.println("Посещение элемента B");
    }
}
