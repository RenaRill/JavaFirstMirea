package builder;

public class ConcreteBuilder implements Builder {
    // Приватное поле для хранения части объекта
    private String part;

    // Метод для установки значения поля part
    @Override
    public void buildPart() {
        part = "Постройка";
    }

    // Метод для получения результата построения
    public String getResult() {
        return part;
    }
}
