package com.example.Java2_14.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
public class Patient {
    @Id
    @SequenceGenerator(name = "patients_seq", sequenceName =
            "patients_sequence", allocationSize = 1)
    @GeneratedValue(generator = "patients_seq", strategy =
            GenerationType.SEQUENCE)
    private Long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @ManyToOne
    @JsonIgnore
    public Doctor doctor;
}