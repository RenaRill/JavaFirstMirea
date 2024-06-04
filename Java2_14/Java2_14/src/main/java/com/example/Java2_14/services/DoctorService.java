package com.example.Java2_14.services;

import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.repositories.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DoctorService {
    @Autowired
    private DoctorRepository repository;
    @Autowired
    private EmailService emailService;

    @Transactional
    public List<Doctor> getDoctors() {
        log.info("Find all doctors");
        return repository.findAll();
    }

    @Transactional
    public void addDoctor(Doctor doctor) {
        log.info("Add doctor");
        repository.save(doctor);
        emailService.sendSimpleMessage("renarill@yandex.ru", "New Doctor Added", "A new doctor has been added.");
    }

    @Transactional
    public void deleteDoctorById(Long id) {
        log.info("Delete doctor");
        repository.deleteDoctorById(id);
    }
    @Transactional
    public List<Doctor> getDoctorsByFieldAsc(String fieldToSort) {
        log.info("Get doctors in ascending order");
        return repository.findAll(Sort.by(Sort.Direction.ASC, fieldToSort));
    }
    @Transactional
    public List<Doctor> getDoctorsByFieldDesc(String fieldToSort) {
        log.info("Get doctors in descending order");
        return repository.findAll(Sort.by(Sort.Direction.DESC, fieldToSort));
    }
}

