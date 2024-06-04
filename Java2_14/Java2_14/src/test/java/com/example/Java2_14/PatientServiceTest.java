package com.example.Java2_14;

import com.example.Java2_14.dto.PatientDTO;
import com.example.Java2_14.models.Doctor;
import com.example.Java2_14.models.Patient;
import com.example.Java2_14.repositories.PatientRepository;
import com.example.Java2_14.services.EmailService;
import com.example.Java2_14.services.PatientService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PatientServiceTest {

    @Mock
    private PatientRepository patientRepository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private PatientService patientService;

    @Captor
    private ArgumentCaptor<Patient> patientCaptor;

    @Test
    void testGetDoctorByPatient() {
        Long patientId = 1L;
        Doctor doctor = new Doctor(); // Предположим, что у вас есть класс Doctor

        when(patientRepository.findDoctorById(patientId)).thenReturn(Optional.of(doctor));

        Doctor result = patientService.getDoctorByPatient(patientId);

        assertThat(result).isEqualTo(doctor);
        verify(patientRepository).findDoctorById(patientId);
    }

    @Test
    void testGetPatients() {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();

        when(patientRepository.findAll()).thenReturn(List.of(patient1, patient2));

        List<PatientDTO> patients = patientService.getPatients();

        assertThat(patients).hasSize(2);
        verify(patientRepository).findAll();
    }

    @Test
    void testAddPatient() {
        Patient patient = new Patient();
        String email = "cyralen@gmail.com";

        when(patientRepository.save(any(Patient.class))).thenAnswer(invocation -> invocation.getArgument(0));
        doNothing().when(emailService).sendSimpleMessage(eq(email), eq("New Patient Added"), eq("A new patient has been added."));

        patientService.addPatient(patient);

        verify(patientRepository).save(patient);
        verify(emailService).sendSimpleMessage(email, "New Patient Added", "A new patient has been added.");
    }

    @Test
    void testDeletePatientById() {
        Long id = 1L;

        patientService.deletePatientById(id);

        verify(patientRepository).deletePatientById(id);
    }

    @Test
    void testGetPatientsAsc() {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        String fieldToSort = "firstName";

        when(patientRepository.findAll(Sort.by(fieldToSort).ascending())).thenReturn(List.of(patient1, patient2));

        List<PatientDTO> patients = patientService.getPatientsAsc(fieldToSort);

        assertThat(patients).containsExactlyInAnyOrderElementsOf(List.of(new PatientDTO(patient1.getId(), patient1.getFirstName(), patient1.getLastName(), patient1.getDoctor()), new PatientDTO(patient2.getId(), patient2.getFirstName(), patient2.getLastName(), patient2.getDoctor())));
        verify(patientRepository).findAll(Sort.by(fieldToSort).ascending());
    }

    @Test
    void testGetPatientsDesc() {
        Patient patient1 = new Patient();
        Patient patient2 = new Patient();
        String fieldToSort = "lastName";

        when(patientRepository.findAll(Sort.by(fieldToSort).descending())).thenReturn(List.of(patient1, patient2));

        List<PatientDTO> patients = patientService.getPatientsDesc(fieldToSort);

        assertThat(patients).containsExactlyInAnyOrderElementsOf(List.of(new PatientDTO(patient2.getId(), patient2.getFirstName(), patient2.getLastName(), patient2.getDoctor()), new PatientDTO(patient1.getId(), patient1.getFirstName(), patient1.getLastName(), patient1.getDoctor())));
        verify(patientRepository).findAll(Sort.by(fieldToSort).descending());
    }
}

