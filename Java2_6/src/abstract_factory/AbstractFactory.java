package abstract_factory;

// Интерфейс AbstractFactory определяет набор методов для создания объектов типа AbstractProduct
public interface AbstractFactory {
    AbstractProduct CreateProductA();
    AbstractProduct CreateProductB();
}
