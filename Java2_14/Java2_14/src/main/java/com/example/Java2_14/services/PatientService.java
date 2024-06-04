package com.example.Java2_14.services;

import com.example.Java2_14.dto.PatientDTO;
import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.models.Patient;
import com.example.Java2_14.repositories.PatientRepository;
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
public class PatientService {
    @Autowired
    private PatientRepository repository;
    @Autowired
    private EmailService emailService;
    @Transactional
    public Doctor getDoctorByPatient(Long patientId) {
        log.info("Get doctor by its patient");
        return repository.findDoctorById(patientId).orElse(null);
    }
    @Transactional
    public List<PatientDTO> getPatients() {
        log.info("Find all patients");
        return repository.findAll().stream().map(x->new PatientDTO(x.getId(), x.getFirstName(), x.getLastName(), x.getDoctor())).toList();
    }
    @Transactional
    public void addPatient(Patient patient) {
        log.info("Add patient");
        repository.save(patient);
        emailService.sendSimpleMessage("cyralen@gmail.com", "New Patient Added", "A new patient has been added.");
    }
    @Transactional
    public void deletePatientById(Long id) {
        log.info("Delete patient");
        repository.deletePatientById(id);
    }
    @Transactional
    public List<PatientDTO> getPatientsAsc(String fieldToSort) {
        log.info("Get patients in ascending order");
        return repository.findAll(Sort.by(fieldToSort).ascending()).stream().map(x->new PatientDTO(x.getId(), x.getFirstName(), x.getLastName(), x.getDoctor())).toList();
    }
    @Transactional
    public List<PatientDTO> getPatientsDesc(String fieldToSort) {
        log.info("Get patients in descending order");
        return repository.findAll(Sort.by(fieldToSort).descending()).stream().map(x->new PatientDTO(x.getId(), x.getFirstName(), x.getLastName(), x.getDoctor())).toList();
    }
}


