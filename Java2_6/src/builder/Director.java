package builder;

public class Director {
    // Приватное поле для хранения экземпляра Builder
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    // Метод для конструирования объекта с помощью Builder
    public void construct() {
        // Вызов метода buildPart() для построения части объекта
        builder.buildPart();
    }
}
