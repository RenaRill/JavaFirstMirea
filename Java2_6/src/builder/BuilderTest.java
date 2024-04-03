package builder;

public class BuilderTest {
    public static void main(String[] args) {
        // Создание экземпляра ConcreteBuilder
        ConcreteBuilder concreteBuilder = new ConcreteBuilder();
        // Создание экземпляра Director с переданным конкретным строителем
        Director director = new Director(concreteBuilder);
        // Вызов метода construct() для начала процесса построения
        director.construct();
        // Получение и вывод результата построения
        String result = concreteBuilder.getResult();
        System.out.println("Результат: " + result);
    }
}
