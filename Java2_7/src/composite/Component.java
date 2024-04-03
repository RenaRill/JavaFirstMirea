package composite;

// Интерфейс Component определяет общий набор операций для всех компонентов
public interface Component {
    // Выполняет операцию над компонентом
    void operation();
    // Добавляет компонент в текущий компонент
    void add(Component c);
    // Удаляет компонент из текущего компонента
    void remove(Component c);
    // Возвращает дочерний компонент по индексу
    Component getChild(int i);
}
