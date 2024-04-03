package facade;

import java.nio.file.Files;
import java.nio.file.Paths;

// Класс для записи файлов
public class FileWriter {
    // Метод для записи содержимого в файл
    public void writeFile(String fileName, String content) {
        try {
            Files.write(Paths.get(fileName), content.getBytes());
            System.out.println("Записываем файл: " + fileName + " с содержимым: " + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
