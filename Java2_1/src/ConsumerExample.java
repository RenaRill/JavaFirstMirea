import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {
        String[] array1 = {"aaa", "def", "fr", "j"};
        String[] array2 = {"12345", "11111", "2344", "1"};
        String[] array3 = {"5678", "sgsgg", "qwert", "545489"};

        // Создаем Consumer, который принимает массив строк
        Consumer<String[]> consumer = (strings) -> {
            // Инициализируем строку с макс. кол-вом уникальных символов, макс. кол-во уникальных символов
            String maxUniqueCharsString = "";
            int maxUniqueChars = 0;
            // Перебираем массив строк
            for (String string : strings) {
                // Множество для хранения уникальных символов (хэш-таблица)
                Set<Character> uniqueChars = new HashSet<>();
                // Перебираем символы в строке
                for (char c : string.toCharArray()) {
                    // Добавляем символы в мн-во уникальных символов
                    uniqueChars.add(c);
                }
                // Если кол-во уникальных символов в текущей строке больше, чем макс. кол-во уник. символов
                if (uniqueChars.size() > maxUniqueChars) {
                    // Обновляем значения переменных
                    maxUniqueChars = uniqueChars.size();
                    maxUniqueCharsString = string;
                }
            }
            System.out.println("Строка с наибольшим кол-вом уникальных символов: " + maxUniqueCharsString);
        };

        // Вызываем Consumer с массивом строк
        consumer.accept(array1);
        consumer.accept(array2);
        consumer.accept(array3);
    }
}