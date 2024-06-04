package com.example.Java2_12;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Компонент для работы с файлами: создание хеша файла и его очистка.
 */
@Component
public class FileHash {
	// Путь к исходному файлу, указанный в конфигурации
	@Value("${source.file}")
	private String sourceFilePath;

	// Путь к файлу с хешем, указанный в конфигурации
	@Value("${hashed.file}")
	private String hashedFilePath;

	/**
	 * Метод, вызываемый после инициализации компонента.
	 * Создает исходный файл, если он не существует, и вычисляет его хеш.
	 */
	@PostConstruct
	public void processFile() {
		File sourceFile = new File(sourceFilePath);
		File hashedFile = new File(hashedFilePath);

		// Если исходный файл не существует, создаем его и записываем "null"
		if (!sourceFile.exists()) {
			try {
				sourceFile.createNewFile();
				try (FileWriter writer = new FileWriter(sourceFile)) {
					writer.write("null");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		// Вычисляем хеш исходного файла и записываем его в файл с хешем
		try (FileInputStream fis = new FileInputStream(sourceFile);
			 FileOutputStream fos = new FileOutputStream(hashedFile)) {

			MessageDigest md = MessageDigest.getInstance("SHA-256");
			byte[] buffer = new byte[1024];
			int bytesRead;

			// Читаем исходный файл по частям и обновляем хеш
			while ((bytesRead = fis.read(buffer)) != -1) {
				md.update(buffer, 0, bytesRead);
			}

			// Получаем хеш и записываем его в файл с хешем
			byte[] hash = md.digest();
			fos.write(hash);

		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Метод, вызываемый перед уничтожением компонента.
	 * Удаляет исходный файл, если он существует.
	 */
	@PreDestroy
	public void cleanup() {
		File sourceFile = new File(sourceFilePath);
		// Удаляем исходный файл, если он существует
		if (sourceFile.exists()) {
			sourceFile.delete();
		}
	}
}
