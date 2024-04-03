package composite;

// Класс Leaf реализует интерфейс Component и представляет собой листовой компонент
public class Leaf implements Component{
    @Override
    public void operation() {
        // Реализация операции для листового компонента
        System.out.println("Я лист!");
    }

    @Override
    public void add(Component c) {
        // Листовые компоненты не могут содержать дочерние компоненты
    }

    @Override
    public void remove(Component c) {
        // Листовые компоненты не могут содержать дочерние компоненты
    }

    @Override
    public Component getChild(int i) {
        // Листовые компоненты не имеют дочерних компонентов
        return null;
    }
}
