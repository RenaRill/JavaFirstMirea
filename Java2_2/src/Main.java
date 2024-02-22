import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


public class Main {
    public static void main(String[] args) {
        // Создаем список из объектов класса Human
        List<Human> humans = new ArrayList<>();
        humans.add(new Human(25, "John", "Doe", LocalDate.of(1995, 4, 15), 73));
        humans.add(new Human(30, "Jane", "Smith", LocalDate.of(1990, 11, 2), 66));
        humans.add(new Human(35, "Bob", "Brown", LocalDate.of(1985, 7, 22), 80));
        humans.add(new Human(40, "Alice", "White", LocalDate.of(2000, 1, 1), 52));
        humans.add(new Human(45, "Tom", "Black", LocalDate.of(2001, 2, 2), 60));

        // Сортировка по сумме веса и возраста
        System.out.println("Сортировка по сумме веса и возраста:");
        humans.stream().sorted(Comparator.comparing(human -> human.getAge() + human.getWeight())).forEach(System.out::println);
        // Фильтрация по весу кратно 5
        System.out.println("Фильтрация по весу кратно 5:");
        humans.stream().filter(human -> human.getWeight() % 5 == 0).forEach(System.out::println);
        // Выбор первых 4 эл-тов
        System.out.println("Выбор первых 4 эл-тов:");
        humans.stream().limit(4).forEach(System.out::println);
        // Конкатенация имен через пробел
        System.out.println("Конкатенация имен через пробел:");
        String concatenatedNames = humans.stream().map(human -> human.getFirstName() + " ")
                // Конкатенируем все имена
                .reduce((name1, name2) -> name1 + name2)
                // Если список пуст, возвращаем пустую строку
                .orElse("");
        System.out.println(concatenatedNames);
    }
}