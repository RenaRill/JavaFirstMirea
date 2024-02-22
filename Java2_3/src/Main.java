import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        // Создаем список, который будет защищен семафором
        MySemaphoreList<Integer> list = new MySemaphoreList<>(new ArrayList<>());
        // Создаем множество, которое будет защищено синхронизацией
        MySynchronizedSet<String> set = new MySynchronizedSet<>(new HashSet<>());

        list.add(1);
        list.add(2);
        list.add(12);

        set.add("Hello");
        set.add("World!");

        System.out.println("Список:");
        for (int element : list) {
            System.out.println(element);
        }

        System.out.println("Множество:");
        for (String element : set) {
            System.out.println(element);
        }
    }
}