package facade;

import java.nio.file.Files;
import java.nio.file.Paths;

// Класс для чтения файлов
public class FileReader {
    // Метод для чтения содержимого файла
    public String readFile(String fileName) {
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(fileName)));
            System.out.println("Читаем файл. ");
            return fileContent;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
