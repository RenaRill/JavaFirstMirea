package main.java.com.example.Java2_13;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StudentInfoPrinter {

    // Используем аннотацию @Value для внедрения значений из файла конфигурации (например, application.properties) в поля класса
    @Value("${student.name}")
    private String name; // Поле для хранения имени студента

    @Value("${student.last_name}")
    private String lastName; // Поле для хранения фамилии студента

    @Value("${student.group}")
    private String group; // Поле для хранения группы студента

    // Метод для вывода информации о студенте
    public void printStudentInfo() {
        System.out.println("Name: " + name);
        System.out.println("Last name: " + lastName);
        System.out.println("Group: " + group);
    }
}
