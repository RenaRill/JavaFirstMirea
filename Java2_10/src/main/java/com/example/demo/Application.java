package com.example.demo;

// Импорт необходимых классов для работы с Spring Framework
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.ApplicationContext;

public class Application {
	public static void main(String[] args) {
		// Создание контекста Spring, используя класс конфигурации AppConfig
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		// Проверка наличия аргументов командной строки
		if (args.length > 0) {
			// Получение имени бина из аргументов командной строки
			String beanName = args[0];
			// Получение бина из контекста по имени и приведение его к типу Programmer
			Programmer programmer = (Programmer) context.getBean(beanName);
			// Вызов метода doCoding у полученного объекта Programmer
			programmer.doCoding();
		} else {
			// Вывод сообщения, если аргументы командной строки не предоставлены
			System.out.println("Please provide a bean name as an argument.");
		}
	}
}
