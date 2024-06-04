package com.example.Java2_14;

import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.repositories.DoctorRepository;
import com.example.Java2_14.services.DoctorService;
import com.example.Java2_14.services.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class) // Используем Mockito для мокирования зависимостей
public class DoctorServiceTest {

    @Mock // Мокируем репозиторий докторов
    private DoctorRepository doctorRepository;

    @Mock // Мокируем сервис отправки электронных писем
    private EmailService emailService;

    @InjectMocks // Инициализируем DoctorService с использованием моков
    private DoctorService doctorService;

    @Captor // Создаем каптор для захвата аргументов в вызовах методов
    private ArgumentCaptor<Doctor> doctorCaptor;

    @Test
    void testGetDoctors() { // Тест проверяет получение списка всех докторов
        Doctor doctor1 = new Doctor(); // Создаем экземпляры докторов для теста
        Doctor doctor2 = new Doctor();

        when(doctorRepository.findAll()).thenReturn(List.of(doctor1, doctor2)); // Настройка поведения мока для findAll()

        List<Doctor> doctors = doctorService.getDoctors(); // Вызываем метод и сохраняем результат

        assertThat(doctors).hasSize(2); // Проверяем, что список содержит два элемента
        verify(doctorRepository).findAll(); // Проверяем, что был вызван метод findAll()
    }

    @Test
    void testAddDoctor() { // Тест проверяет добавление нового доктора
        Doctor doctor = new Doctor(); // Создаем объект доктора для теста
        String email = "test@example.com"; // Предполагаемый адрес электронной почты

        when(doctorRepository.save(any(Doctor.class))).thenAnswer(invocation -> invocation.getArgument(0)); // Настройка поведения мока для save()
        doNothing().when(emailService).sendSimpleMessage(eq("renarill@yandex.ru"), eq("New Doctor Added"), eq("A new doctor has been added.")); // Настройка поведения мока для sendSimpleMessage()

        doctorService.addDoctor(doctor); // Вызываем метод добавления доктора

        verify(doctorRepository).save(doctor); // Проверяем, что метод save() был вызван с переданным доктором
        verify(emailService).sendSimpleMessage("renarill@yandex.ru", "New Doctor Added", "A new doctor has been added."); // Проверяем, что метод sendSimpleMessage() был вызван с правильными параметрами
    }

    @Test
    void testDeleteDoctorById() { // Тест проверяет удаление доктора по ID
        Long id = 1L; // Предполагаемый ID доктора

        doctorService.deleteDoctorById(id); // Вызываем метод удаления

        verify(doctorRepository).deleteDoctorById(id); // Проверяем, что метод deleteDoctorById() был вызван с правильным ID
    }

    @Test
    void testGetDoctorsByFieldAsc() { // Тест проверяет получение списка докторов отсортированных по полю в порядке возрастания
        Doctor doctor1 = new Doctor(); // Создаем экземпляры докторов для теста
        Doctor doctor2 = new Doctor();
        String fieldToSort = "specialization"; // Поле для сортировки

        when(doctorRepository.findAll(Sort.by(Sort.Direction.ASC, fieldToSort))).thenReturn(List.of(doctor1, doctor2)); // Настройка поведения мока для findAll() с сортировкой

        List<Doctor> doctors = doctorService.getDoctorsByFieldAsc(fieldToSort); // Вызываем метод и сохраняем результат

        assertThat(doctors).containsExactlyInAnyOrder(doctor1, doctor2); // Проверяем, что список содержит ожидаемых докторов
        verify(doctorRepository).findAll(Sort.by(Sort.Direction.ASC, fieldToSort)); // Проверяем, что был вызван метод findAll() с правильной сортировкой
    }

    @Test
    void testGetDoctorsByFieldDesc() { // Тест проверяет получение списка докторов отсортированных по полю в порядке убывания
        Doctor doctor1 = new Doctor(); // Создаем экземпляры докторов для теста
        Doctor doctor2 = new Doctor();
        String fieldToSort = "specialization"; // Поле для сортировки

        when(doctorRepository.findAll(Sort.by(Sort.Direction.DESC, fieldToSort))).thenReturn(List.of(doctor1, doctor2)); // Настройка поведения мока для findAll() с сортировкой

        List<Doctor> doctors = doctorService.getDoctorsByFieldDesc(fieldToSort); // Вызываем метод и сохраняем результат

        assertThat(doctors).containsExactlyInAnyOrder(doctor2, doctor1); // Проверяем, что список содержит ожидаемых докторов в обратном порядке
        verify(doctorRepository).findAll(Sort.by(Sort.Direction.DESC, fieldToSort)); // Проверяем, что был вызван метод findAll() с правильной сортировкой
    }
}

