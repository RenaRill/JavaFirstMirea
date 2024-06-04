package com.example.Java2_14.repositories;

import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.models.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    @Query("SELECT p FROM Patient p")
    Optional<List<Patient>> getAllPatients();
    Optional<Integer> deletePatientById(Long id);
    @Query("SELECT p.doctor FROM Patient p WHERE p.id = :id")
    Optional<Doctor> findDoctorById(@Param("id") Long id);
}
