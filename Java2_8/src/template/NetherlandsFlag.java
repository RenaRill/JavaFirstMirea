package template;

// Конкретный класс, реализующий флаг Нидерландов
class NetherlandsFlag extends AbstractFlag {
    @Override
    void drawUpperLevel() {
        System.out.println("Полоса красного цвета нарисована");
    }

    @Override
    void drawMiddleLevel() {
        System.out.println("Полоса белого цвета нарисована");
    }

    @Override
    void drawBottomLevel() {
        System.out.println("Полоса синего цвета нарисована");
    }
}
