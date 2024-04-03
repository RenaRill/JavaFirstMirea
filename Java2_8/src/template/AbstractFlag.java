package template;

// Абстрактный класс, определяющий шаблонный метод для рисования флага
abstract class AbstractFlag {
    // Абстрактные методы, которые должны быть реализованы в подклассах
    abstract void drawUpperLevel();
    abstract void drawMiddleLevel();
    abstract void drawBottomLevel();

    // Шаблонный метод, который определяет общий алгоритм рисования флага
    final void drawFlag() {
        drawFlagpole(); // Рисуем флагшток
        drawUpperLevel(); // Рисуем верхний уровень флага
        drawMiddleLevel(); // Рисуем средний уровень флага
        drawBottomLevel(); // Рисуем нижний уровень флага
    }

    // Приватный метод для рисования флагштока, который не может быть переопределен в подклассах
    private void drawFlagpole() {
        System.out.println("Флагшток нарисован");
    }
}
