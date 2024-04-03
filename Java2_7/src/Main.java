import composite.Composite;
import composite.Leaf;
import facade.FileFacade;

public class Main {
    public static void main(String[] args) {
        // Создание листовых узлов
        Leaf leaf1 = new Leaf();
        Leaf leaf2 = new Leaf();

        // Создание составных узлов
        Composite composite1 = new Composite();
        Composite composite2 = new Composite();

        // Добавление листовых узлов в составные узлы
        composite1.add(leaf1);
        composite1.add(leaf2);

        // Добавление составных узлов в другие составные узлы
        composite2.add(composite1);

        // Выполнение операций над составными узлами
        composite2.operation();

        FileFacade fileFacade = new FileFacade();

        // Запись и шифрование файла
        fileFacade.writeAndEncryptFile("example.txt", "Тестовое содержание.");
    }
}
//Компоновщик, Фасад