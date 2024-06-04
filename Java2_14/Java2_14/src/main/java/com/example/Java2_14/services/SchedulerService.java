package com.example.Java2_14.services;

import com.example.Java2_14.dto.PatientDTO;
import com.example.Java2_14.models.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Component
@EnableScheduling
public class SchedulerService {

    private final PatientService patientService;
    private final DoctorService doctorService;
    private final String url = "C:\\Users\\Rena\\IdeaProjects\\Exam\\Java2_14\\Java2_14\\src\\main\\resources";

    @Autowired
    public SchedulerService(PatientService patientService, DoctorService doctorService) {
        this.patientService = patientService;
        this.doctorService = doctorService;
    }

    @Scheduled(cron = "0 */30 * * * *")
    public void doScheduledTask() throws IOException {
        File dir = new File(url);
        clearDirectory(dir);
        saveData(dir);
    }

    private void saveData(File dir) throws IOException {
        List<PatientDTO> patients = patientService.getPatients();
        List<Doctor> doctors = doctorService.getDoctors();
        writeFile(url + "/patients.txt", patients.toString());
        writeFile(url + "/doctors.txt", doctors.toString());
    }

    private void clearDirectory(File dir) {
        for (File file : dir.listFiles()) {
            if (!file.isDirectory()) {
                file.delete();
            }
        }
    }

    private void writeFile(String fileName, String content) throws IOException {
        try {
            Path newFilePath = Paths.get(fileName);
            Files.createFile(newFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
