package com.example.Java2_14.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "doctors")
@Getter
@Setter
public class Doctor {
    @Id
    @SequenceGenerator(name = "doctors_seq", sequenceName =
            "doctors_sequence", allocationSize = 1)
    @GeneratedValue(generator = "doctors_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "position")
    private String position;
    @OneToMany(mappedBy = "doctor", fetch = FetchType.EAGER)
    private List<Patient> patients;
}

