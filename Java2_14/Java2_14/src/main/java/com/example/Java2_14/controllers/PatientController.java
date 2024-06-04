package com.example.Java2_14.controllers;

import com.example.Java2_14.dto.PatientDTO;
import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.models.Patient;
import com.example.Java2_14.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping("/add")
    @ResponseBody
    public Patient createPatient(@RequestBody Patient patient) {
        service.addPatient(patient);
        return patient;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<PatientDTO> getPatients() {
        return service.getPatients();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deletePatient(@RequestParam Long id) {
        service.deletePatientById(id);
    }

    @GetMapping(value = "/patient/{patientId}/doctor")
    public @ResponseBody Doctor getPatientDoctor(@PathVariable("patientId")
                                         Long patientId){
        return service.getDoctorByPatient(patientId);
    }

    @GetMapping("/asc/{fieldToSort}")
    public List<PatientDTO> getPatientsAsc(@PathVariable String fieldToSort) {
        return service.getPatientsAsc(fieldToSort);
    }
    @GetMapping("/desc/{fieldToSort}")
    public List<PatientDTO> getPatientsDesc(@PathVariable String fieldToSort) {
        return service.getPatientsDesc(fieldToSort);
    }
}
