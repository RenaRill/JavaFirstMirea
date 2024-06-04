package main.java.com.example.Java2_13;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class Java213Application {

	// Поле для хранения экземпляра класса StudentInfoPrinter, который будет автоматически внедрен Spring'ом
	private final StudentInfoPrinter student;

	// Конструктор, который принимает экземпляр класса StudentInfoPrinter и инициализирует поле student
	public Java213Application(StudentInfoPrinter student) {
		this.student = student;
	}

	// Главный метод приложения, который запускает Spring Boot приложение
	public static void main(String[] args) {
		SpringApplication.run(Java213Application.class, args);
	}

	// Метод, аннотированный @EventListener, который будет вызван после того, как приложение будет полностью запущено и готово к обработке запросов
	// Этот метод вызывает printStudentInfo() из класса StudentInfoPrinter для вывода информации о студенте
	@EventListener(ApplicationReadyEvent.class)
	public void printStudent() {
		student.printStudentInfo();
	}

}
