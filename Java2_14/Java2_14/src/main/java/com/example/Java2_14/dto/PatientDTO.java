package com.example.Java2_14.dto;

import com.example.Java2_14.models.Doctor;

public record PatientDTO(Long id, String firstName, String lastName, Doctor doctor) {
}
