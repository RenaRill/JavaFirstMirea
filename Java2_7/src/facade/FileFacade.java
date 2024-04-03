package facade;

// Фасад для работы с файлами
public class FileFacade {
    private FileReader fileReader;
    private FileWriter fileWriter;
    private FileEncryptor fileEncryptor;

    // Конструктор для инициализации объектов
    public FileFacade() {
        this.fileReader = new FileReader();
        this.fileWriter = new FileWriter();
        this.fileEncryptor = new FileEncryptor();
    }

    // Метод для чтения и шифрования файла
    public void readAndEncryptFile(String fileName) {
        String fileContent = fileReader.readFile(fileName);
        if (fileContent != null) {
            String encryptedContent = fileEncryptor.encryptFile(fileContent);
            System.out.println(encryptedContent);
        }
    }

    // Метод для записи и шифрования файла
    public void writeAndEncryptFile(String fileName, String content) {
        String encryptedContent = fileEncryptor.encryptFile(content);
        fileWriter.writeFile(fileName, encryptedContent);
    }
}
