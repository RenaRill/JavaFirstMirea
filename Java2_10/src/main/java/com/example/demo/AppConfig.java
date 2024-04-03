package com.example.demo;

// Импорт необходимых классов для работы с Spring Framework
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Аннотация @Configuration указывает, что данный класс является источником определений бинов для контекста Spring
@Configuration
public class AppConfig {

    // Метод, который создает бин типа Programmer с именем "junior"
    @Bean("junior")
    public Programmer juniorProgrammer() {
        // Возвращает новый экземпляр класса Junior, который реализует интерфейс Programmer
        return new Junior();
    }

    // Метод, который создает бин типа Programmer с именем "middle"
    @Bean("middle")
    public Programmer middleProgrammer() {
        // Возвращает новый экземпляр класса Middle, который реализует интерфейс Programmer
        return new Middle();
    }

    // Метод, который создает бин типа Programmer с именем "senior"
    @Bean("senior")
    public Programmer seniorProgrammer() {
        // Возвращает новый экземпляр класса Senior, который реализует интерфейс Programmer
        return new Senior();
    }
}

