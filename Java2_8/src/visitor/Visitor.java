package visitor;

// Интерфейс Visitor определяет методы для работы с элементами
public interface Visitor {
    public void visitElementA(ConcreteElementA a);
    public void visitElementB(ConcreteElementB b);

}
