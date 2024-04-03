package factory_method;

// Создатель с фабричным методом
abstract class Creator {
    // Фабричный метод, который должны реализовать подклассы
    public abstract Product factoryMethod();

    // Обычный метод использующий фабричный метод для создания продукта
    public void anOperation() {
        Product product = factoryMethod();
        product.doSomething();
    }
}
