package com.example.Java2_14.controllers;

import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @Autowired
    private DoctorService service;

    @PostMapping("/add")
    @ResponseBody
    public Doctor createDoctor(@RequestBody Doctor doctor) {
        service.addDoctor(doctor);
        return doctor;
    }

    @GetMapping("/all")
    @ResponseBody
    public List<Doctor> getDoctors() {
        return service.getDoctors();
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void deleteDoctor(@RequestParam Long id) {
        service.deleteDoctorById(id);
    }

    @GetMapping("/asc/{fieldToSort}")
    public List<Doctor> getDoctorsByAsc(@PathVariable String fieldToSort) {
        return service.getDoctorsByFieldAsc(fieldToSort);
    }
    @GetMapping("/desc/{fieldToSort}")
    public List<Doctor> getDoctorsByDesc(@PathVariable String fieldToSort) {
        return service.getDoctorsByFieldDesc(fieldToSort);
    }
}


