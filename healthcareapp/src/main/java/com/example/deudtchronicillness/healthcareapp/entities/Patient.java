package com.example.deudtchronicillness.healthcareapp.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


;import java.time.LocalDate;
import java.util.Date;

@Entity
@Table (name = "patient")
@Data
public class Patient {
    @Id
    Long id;


    String name;
    String surname;
    int height;
    LocalDate dateOfBirth;

}
