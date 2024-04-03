package factory_method;

// Конкретный создатель наследует абстрактный класс Creator
class ConcreteCreator extends Creator {
    
    // Возвращает новый экземпляр ConcreteProduct
    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }
}
