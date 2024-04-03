package visitor;

// Интерфейс Element определяет метод accept, который принимает объект Visitor
public interface Element {
    public void accept(Visitor v);
}
