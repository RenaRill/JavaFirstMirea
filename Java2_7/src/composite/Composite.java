package composite;

import java.util.List;
import java.util.ArrayList;

// Класс Composite реализует интерфейс Component и может содержать другие компоненты
public class Composite implements Component {
    // Список дочерних компонентов
    private List<Component> children = new ArrayList<>();

    @Override
    public void operation() {
        // Выполняет операцию над каждым дочерним компонентом
        for (Component child : children) {
            child.operation();
        }
    }

    @Override
    public void add(Component c) {
        // Добавляет компонент в список дочерних компонентов
        children.add(c);
    }

    @Override
    public void remove(Component c) {
        // Удаляет компонент из списка дочерних компонентов
        children.remove(c);
    }

    @Override
    public Component getChild(int i) {
        // Возвращает дочерний компонент по индексу
        return children.get(i);
    }
}
